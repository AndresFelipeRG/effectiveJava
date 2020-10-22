package com.effectivejava.items.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MailComponentImpl implements MailComponent {

    private final JavaMailSender javaMailSender;

    @Override
    public void sendMessage(String to, String subject, String body) {
        SimpleMailMessage simpleMessage = new SimpleMailMessage();
        simpleMessage.setTo(to);
        simpleMessage.setSubject(subject);
        simpleMessage.setText(body);
        javaMailSender.send(simpleMessage);

    }
}
