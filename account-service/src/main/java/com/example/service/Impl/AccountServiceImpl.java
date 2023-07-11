package com.example.service.Impl;

import com.example.model.Account;
import com.example.model.Message;
import com.example.model.Statistic;
import com.example.repository.AccountRepo;
import com.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;


    @Override
    public Account createAccount(Account account) {
        accountRepo.save(account);
        Statistic stat = Statistic.builder()
                .message("Account " + account.getEmail() + " is created!!")
                .createdDate(new Date())
                .build();
        Message mess = Message.builder()
                .to(account.getEmail())
                .toName(account.getName())
                .subject("Welcome to Kafka demo")
                .content("Thanks for subscribing to our Kafka demo system!!")
                .build();
        kafkaTemplate.send("notification", mess);
        kafkaTemplate.send("statistic", stat);
        return account;
    }
}
