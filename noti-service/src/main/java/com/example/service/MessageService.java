package com.example.service;

import com.example.model.Message;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageService {
    @Autowired
    private NotiService notiService;

    @KafkaListener(id = "notificationGroup", topics = "notification")
    public void listen(Message message) throws MessagingException {
        log.info("Received: " + message.getTo());
        notiService.sendNotiEmail(message);
    }
}
