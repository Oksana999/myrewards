package com.example.myrewards.service;

import com.example.myrewards.data.TransactionRepository;
import com.example.myrewards.data.UserRepository;
import com.example.myrewards.models.Transaction;
import com.example.myrewards.models.User;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

        private final UserRepository userRepository;

        private final TransactionRepository transactionRepository;

        public TransactionService(UserRepository userRepository,
                                  TransactionRepository transactionRepository) {
            this.userRepository = userRepository;
            this.transactionRepository = transactionRepository;
        }

        public List<Transaction> getByUser(Integer userId) {
            Optional<User> optionalUser = userRepository.findById(userId);
            User user = new User();
            if(optionalUser.isPresent()) {
                 user = optionalUser.get();
            }
            return transactionRepository.findAllByUser(user);
        }

        public void saveTransaction(BigDecimal amount,  Integer userId) {
            Optional<User> userOptional = userRepository.findById(userId);
            if (userOptional.isPresent()) {
                Transaction transaction = new Transaction();
                transaction.setAmount(amount);
             //   transaction.setDate(System.currentTimeMillis());
                int points = 0;
                if(amount.compareTo(BigDecimal.valueOf(50)) > 0 && amount.compareTo(BigDecimal.valueOf(100)) < 0) {
                     points = (int)Math.floor(amount.subtract(BigDecimal.valueOf(50)).doubleValue());
                }
                if(amount.compareTo(BigDecimal.valueOf(100)) > 0) {
                    points = (int)Math.floor(amount.subtract(BigDecimal.valueOf(100)).doubleValue()) + 50;
                }
                transaction.setPoints(points);

                transactionRepository.save(transaction);

            }
        }
    }

