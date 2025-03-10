package com.nichiin.WebScraping.configuration;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

@Component
public class XMLMapperConfiguration {
    private String dbUrl;
    private String dbUsername;
    private String dbPassword;
    private String dbDriver;
    private String hibernateDialect;
    private String ddlAuto;
    private String customCsvPath;
    private String mailHost;
    private int mailPort;
    private String mailUsername;
    private String mailPassword;
    private String mailProtocol;
    private boolean mailAuth;
    private boolean mailEnable;
    private String mailTo;
    private String mailCc;

    @PostConstruct
    public void loadConfig() {
        try {

            String xmlFilePath = System.getProperty("config.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document;

            File file = new File(xmlFilePath);
            document = builder.parse(file);
            System.out.println("File loaded successfully " + file.getAbsoluteFile());

            document.getDocumentElement().normalize();
            Element values = (Element) document.getElementsByTagName("values").item(0);

            dbUrl = values.getElementsByTagName("url").item(0).getTextContent();
            dbUsername = values.getElementsByTagName("username").item(0).getTextContent();
            dbPassword = values.getElementsByTagName("password").item(0).getTextContent();
            dbDriver = values.getElementsByTagName("driver-class-name").item(0).getTextContent();
            hibernateDialect = values.getElementsByTagName("hibernate-dialect").item(0).getTextContent();
            ddlAuto = values.getElementsByTagName("ddl-auto").item(0).getTextContent();
            customCsvPath = values.getElementsByTagName("csv-path").item(0).getTextContent();
            mailHost = values.getElementsByTagName("mail-host").item(0).getTextContent();
            mailPort = Integer.parseInt(values.getElementsByTagName("mail-port").item(0).getTextContent());
            mailUsername = values.getElementsByTagName("mail-username").item(0).getTextContent();
            mailPassword = values.getElementsByTagName("mail-password").item(0).getTextContent();
            mailProtocol = values.getElementsByTagName("mail-protocol").item(0).getTextContent();
            mailAuth = Boolean.parseBoolean(values.getElementsByTagName("mail-auth").item(0).getTextContent());
            mailEnable = Boolean.parseBoolean(values.getElementsByTagName("mail-enable").item(0).getTextContent());
            mailTo = values.getElementsByTagName("mail-to").item(0).getTextContent();
            mailCc = values.getElementsByTagName("mail-cc").item(0).getTextContent();

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public String getDbUsername() {
        return dbUsername;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public String getDbDriver() {
        return dbDriver;
    }

    public String getHibernateDialect() {
        return hibernateDialect;
    }

    public String getDdlAuto() {
        return ddlAuto;
    }

    public String getCustomCsvPath() {
        return customCsvPath;
    }

    public String getMailHost() {
        return mailHost;
    }

    public int getMailPort() {
        return mailPort;
    }

    public String getMailUsername() {
        return mailUsername;
    }

    public String getMailPassword() {
        return mailPassword;
    }

    public String getMailProtocol() {
        return mailProtocol;
    }

    public boolean getMailAuth() {
        return mailAuth;
    }

    public boolean getMailEnable() {
        return mailEnable;
    }

    public String getMailTo() {
        return mailTo;
    }

    public String getMailCc() {
        return mailCc;
    }
}
