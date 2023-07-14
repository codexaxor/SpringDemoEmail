package io.getarrays.userservice.service.impl;

import io.getarrays.userservice.controller.dto.SendMailResponseBody;
import io.getarrays.userservice.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import static io.getarrays.userservice.utils.EmailUtils.getEmailMessage;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    public static final String EMAIL_SUBJECT = "Custom Email Service";

    private final JavaMailSender emailSender;
    @Value("${spring.mail.username}")
    private String fromEmail;

    @Override
//    @Async
    public SendMailResponseBody sendSimpleMailMessage(String name, String to) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject(EMAIL_SUBJECT);
            message.setFrom(fromEmail);
            message.setTo(to);
            message.setText(getEmailMessage(name));
            emailSender.send(message);
            return new SendMailResponseBody("Successfully sent e-mail");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            throw new RuntimeException(exception.getMessage());
        }
    }
}