package com.nichiin.WebScraping.configuration;

import jakarta.annotation.PostConstruct;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class SeleniumConfiguration {

    @Value("${application.custom.download.path}")
    private String customPath;

    private String customDownloadPath;

    @PostConstruct
    public void init() {
        this.customDownloadPath = System.getProperty("user.home") + customPath;
    }

    @Bean
    public ChromeDriver driver() {
        if (customDownloadPath == null || customDownloadPath.isEmpty()) {
            throw new IllegalStateException("Custom download path is not set correctly.");
        }

        System.out.println("Download path: " + customDownloadPath);

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", customDownloadPath);
        prefs.put("download.prompt_for_download", false);
        prefs.put("safebrowsing.enabled", true);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", List.of("enable-automation"));
        options.setExperimentalOption("prefs", prefs);
//        options.addArguments("disable-infobars");
//        options.addArguments("--headless");
//        options.addArguments("--window-size=1325x744");
        System.out.println("end");
        return new ChromeDriver(options);
    }
}
