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

    private final XMLMapperConfiguration xmlMapperConfiguration;

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost(xmlMapperConfiguration.getMailHost());
        sender.setPort(xmlMapperConfiguration.getMailPort());
        sender.setUsername(xmlMapperConfiguration.getMailUsername());
        sender.setPassword(xmlMapperConfiguration.getMailPassword());

        Properties props = sender.getJavaMailProperties();
        props.put("mail.transport.protocol", xmlMapperConfiguration.getMailProtocol());
        props.put("mail.smtp.auth", xmlMapperConfiguration.isMailAuth());
        props.put("mail.smtp.starttls.enable", xmlMapperConfiguration.isMailEnable());
        props.put("mail.debug", "true");

        return sender;
    }

}
