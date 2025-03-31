package com.nichiin.WebScraping.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
@RequiredArgsConstructor
public class MailConfiguration {

    private final MailConfig mailConfig;

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost(mailConfig.getMailHost());
        sender.setPort(mailConfig.getMailPort());
        sender.setUsername(mailConfig.getMailUsername());
        sender.setPassword(mailConfig.getMailPassword());

        Properties props = sender.getJavaMailProperties();
        props.put("mail.transport.protocol", mailConfig.getMailProtocol());
        props.put("mail.smtp.auth", mailConfig.isMailAuth());
        props.put("mail.smtp.starttls.enable", mailConfig.isMailEnable());
        props.put("mail.debug", "true");

        return sender;
    }

}
