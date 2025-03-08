package com.nichiin.WebScraping.service;

import com.nichiin.WebScraping.configuration.XMLMapperConfiguration;
import com.nichiin.WebScraping.mail.MailContent;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class DownloadCsvService {
    private final XMLMapperConfiguration xmlMapperConfiguration;

    private static final String URL = "https://www.nseindia.com/market-data/pre-open-market-cm-and-emerge-market";
    private final ChromeDriver driver;
    private String DOWNLOAD_PATH;
    private final MailContent mailContent;

    @PostConstruct
    public void init() {
        String customPath = xmlMapperConfiguration.getCustomCsvPath();
        this.DOWNLOAD_PATH = System.getProperty("user.home") + customPath;
    }

    public String scrapeTableData() {
        System.out.println("Downloading is in process");
        try {
            driver.get(URL);
            System.out.println("Header: " + driver.getTitle());
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement downloadButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("dwldcsv")));
            downloadButton.click();
            String filename = generateFileName();
            return waitForFileDownload(filename);

        }catch (Exception e) {
            System.out.println(e.getMessage());
            mailContent.sendDownloadFailedMail();
        }
        return "";
    }

    public static String generateFileName() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        String dateStr = dateFormat.format(new Date());
        return "MW-Pre-Open-Market-" + dateStr + ".csv";
    }

    public String waitForFileDownload(String filename) {
        File file = new File(DOWNLOAD_PATH, filename);
        System.out.println(file.getAbsoluteFile());
        int attempt = 0;
        while (attempt < 20) {
            if (file.exists()) {
                System.out.println("File downloaded successfully: " + file.getAbsoluteFile());
                return file.getAbsoluteFile().toString();
            }
            attempt++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException ignored) {}
        }
        System.out.println("Download failed or took too long.");

        return "nun";
    }

}
