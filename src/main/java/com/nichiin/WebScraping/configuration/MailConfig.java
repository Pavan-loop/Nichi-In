package com.nichiin.WebScraping.configuration;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class MailConfig {
    private String mailHost;
    private int mailPort;
    private String mailUsername;
    private String mailPassword;
    private String mailProtocol;
    private boolean mailAuth;
    private boolean mailEnable;
    private String mailTo;
    private String mailCc;
    private String mailSub;
    private String mailSuccessContent;
    private String mailErrorContent;
    private String mailDBErrorContent;

    public void setMailConfig(
            String mailHost,
            int mailPort,
            String mailUsername,
            String mailPassword,
            String mailProtocol,
            boolean mailAuth,
            boolean mailEnable,
            String mailTo,
            String mailCc,
            String mailSub,
            String mailSuccessContent,
            String mailErrorContent,
            String mailDBErrorContent
    ) {
        this.mailHost = mailHost;
        this.mailPort = mailPort;
        this.mailUsername = mailUsername;
        this.mailPassword = mailPassword;
        this.mailProtocol = mailProtocol;
        this.mailAuth = mailAuth;
        this.mailEnable = mailEnable;
        this.mailTo = mailTo;
        this.mailCc = mailCc;
        this.mailSub = mailSub;
        this.mailSuccessContent = mailSuccessContent;
        this.mailErrorContent = mailErrorContent;
        this.mailDBErrorContent = mailDBErrorContent;
    }
}
