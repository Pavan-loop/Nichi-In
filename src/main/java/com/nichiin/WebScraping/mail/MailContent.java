package com.nichiin.WebScraping.mail;

import com.nichiin.WebScraping.configuration.MailConfig;
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
    private final MailConfig mailConfig;

    public void sendSuccessMail() {
        try {

            List<String> email = List.of(mailConfig.getMailCc().split(","));

            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(mailConfig.getMailTo());
            helper.setCc(email.toArray(new String[0]));
            helper.setSubject(mailConfig.getMailSub());
            helper.setText(mailConfig.getMailSuccessContent());

            javaMailSender.send(message);
        }catch (Exception e) {
           log.error("Error while send mail: {}", e.getMessage());
        }
    }

    public void sendDownloadFailedMail() {
        try {

            List<String> email = List.of(mailConfig.getMailCc().split(","));
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(mailConfig.getMailTo());
            helper.setCc(email.toArray(new String[0]));
            helper.setSubject(mailConfig.getMailSub());
            helper.setText(mailConfig.getMailErrorContent());
            javaMailSender.send(message);
        }catch (Exception e) {
            log.error("Error while send mail: {}", e.getMessage());
        }
    }

    public void sendDatabaseFailedMail() {
        try {
            List<String> email = List.of(mailConfig.getMailCc().split(","));

            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(mailConfig.getMailTo());
            helper.setCc(email.toArray(new String[0]));
            helper.setSubject(mailConfig.getMailSub());
            helper.setText(mailConfig.getMailDBErrorContent());

            javaMailSender.send(message);
        }catch (Exception e) {
            log.error("Error while send mail: {}", e.getMessage());
        }
    }
}
