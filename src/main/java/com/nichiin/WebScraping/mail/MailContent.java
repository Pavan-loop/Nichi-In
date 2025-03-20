package com.nichiin.WebScraping.mail;

import com.nichiin.WebScraping.configuration.XMLMapperConfiguration;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class MailContent {

    private final JavaMailSender javaMailSender;
    private final XMLMapperConfiguration xmlMapperConfiguration;

    public void sendSuccessMail() {
        try {

            List<String> email = List.of(xmlMapperConfiguration.getMailCc().split(","));

            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(xmlMapperConfiguration.getMailTo());
            helper.setCc(email.toArray(new String[0]));
            helper.setSubject("WebScraper Update");
            helper.setText("The program successfully downloaded the CSV file and processed the data into the database.");

            javaMailSender.send(message);
        }catch (Exception e) {
           log.error("Error while send mail: {}", e.getMessage());
        }
    }

    public void sendDownloadFailedMail() {
        try {

            List<String> email = List.of(xmlMapperConfiguration.getMailCc().split(","));
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(xmlMapperConfiguration.getMailTo());
            helper.setCc(email.toArray(new String[0]));
            helper.setSubject("WebScraper Update");
            helper.setText("Program Failed to download csv from website");
            javaMailSender.send(message);
        }catch (Exception e) {
            log.error("Error while send mail: {}", e.getMessage());
        }
    }

    public void sendDatabaseFailedMail() {
        try {
            List<String> email = List.of(xmlMapperConfiguration.getMailCc().split(","));

            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(xmlMapperConfiguration.getMailTo());
            helper.setCc(email.toArray(new String[0]));
            helper.setSubject("WebScraper Update");
            helper.setText("Program Failed to update the data into database");

            javaMailSender.send(message);
        }catch (Exception e) {
            log.error("Error while send mail: {}", e.getMessage());
        }
    }
}
