package com.example.myrewards.data;

import com.example.myrewards.models.Transaction;
import com.example.myrewards.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
    List<Transaction> findAllByUser(User user);
}
