package com.example.service;

import com.example.email.EmailService;
import com.example.model.Message;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotiService {
    @Autowired
    private EmailService emailService;

//    @Async
    public void sendNotiEmail(Message message) throws MessagingException {
        log.info("Start... Sending email");

        emailService.sendMail(message);

        log.info("End... Email sent successfully");
    }
}
