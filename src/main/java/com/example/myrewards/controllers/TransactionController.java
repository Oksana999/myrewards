package com.example.myrewards.controllers;

import com.example.myrewards.data.TransactionRepository;
import com.example.myrewards.data.UserRepository;
import com.example.myrewards.models.Transaction;
import com.example.myrewards.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/")
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("transactions")
    public List<Transaction> getTransactions(){
        User oksana = this.userRepository.getUserByName("Oksana");

        return this.transactionRepository.findAllByUser(oksana);
    }
}
