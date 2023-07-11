package com.example.email;

import com.example.model.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailService {
    @Autowired
    private final JavaMailSender javaMailSender;
    public void sendMail(Message message) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        mimeMessageHelper.setFrom("noreply@example.com");
        mimeMessageHelper.setTo(message.getTo());
        mimeMessageHelper.setSubject(message.getSubject());
        mimeMessageHelper.setText(message.getContent());
        javaMailSender.send(mimeMessage);
    }
}
