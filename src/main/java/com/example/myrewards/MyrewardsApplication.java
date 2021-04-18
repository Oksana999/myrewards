package com.example.myrewards;

import com.example.myrewards.data.TransactionRepository;
import com.example.myrewards.data.UserRepository;
import com.example.myrewards.models.Transaction;
import com.example.myrewards.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.math.BigDecimal;

@ComponentScan("com.example") //to scan packages mentioned
@SpringBootApplication
public class MyrewardsApplication implements CommandLineRunner {

	@Autowired
	private final TransactionRepository transactionRepository;
	@Autowired
	private final UserRepository userRepository;

//	public MyrewardsApplication(TransactionRepository transactionRepository,
//								UserRepository userRepository) {
//		this.transactionRepository = transactionRepository;
//		this.userRepository = userRepository;
//	}

	public static void main(String[] args) {

		SpringApplication.run(MyrewardsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.userRepository.save(new User("Oksana"));
		this.transactionRepository.save(new Transaction(BigDecimal.valueOf(100), 50,
				userRepository.getUserByName("Oksana")));

	}
}
