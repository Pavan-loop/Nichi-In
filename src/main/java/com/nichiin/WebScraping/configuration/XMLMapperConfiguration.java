package com.nichiin.WebScraping.configuration;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

@Component
@Getter
@RequiredArgsConstructor
public class XMLMapperConfiguration {
    private final CheckConfig check;
    private final DBConfig dbConfig;
    private final CsvPathConfig csvPathConfig;
    private final MailConfig mailConfig;

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
            Element dbValues = (Element) document.getElementsByTagName("db-config").item(0);

            dbConfig.setDBConfig(
                    dbValues.getElementsByTagName("url").item(0).getTextContent(),
                    dbValues.getElementsByTagName("username").item(0).getTextContent(),
                    dbValues.getElementsByTagName("password").item(0).getTextContent(),
                    dbValues.getElementsByTagName("driver-class-name").item(0).getTextContent(),
                    dbValues.getElementsByTagName("hibernate-dialect").item(0).getTextContent(),
                    dbValues.getElementsByTagName("ddl-auto").item(0).getTextContent()
            );

            Element csvPathValue = (Element) document.getElementsByTagName("csv-paths").item(0);

            csvPathConfig.setCustomCsvPath(
                    csvPathValue.getElementsByTagName("csv-path").item(0).getTextContent()
            );

            Element mailValues = (Element) document.getElementsByTagName("mail-config").item(0);

            mailConfig.setMailConfig(
                    mailValues.getElementsByTagName("mail-host").item(0).getTextContent(),
                    Integer.parseInt(mailValues.getElementsByTagName("mail-port").item(0).getTextContent()),
                    mailValues.getElementsByTagName("mail-username").item(0).getTextContent(),
                    mailValues.getElementsByTagName("mail-password").item(0).getTextContent(),
                    mailValues.getElementsByTagName("mail-protocol").item(0).getTextContent(),
                    Boolean.parseBoolean(mailValues.getElementsByTagName("mail-auth").item(0).getTextContent()),
                    Boolean.parseBoolean(mailValues.getElementsByTagName("mail-enable").item(0).getTextContent()),
                    mailValues.getElementsByTagName("mail-to").item(0).getTextContent(),
                    mailValues.getElementsByTagName("mail-cc").item(0).getTextContent(),
                    mailValues.getElementsByTagName("mail-sub").item(0).getTextContent(),
                    mailValues.getElementsByTagName("mail-success-content").item(0).getTextContent(),
                    mailValues.getElementsByTagName("mail-error-content").item(0).getTextContent(),
                    mailValues.getElementsByTagName("mail-dberror-content").item(0).getTextContent()
            );

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
