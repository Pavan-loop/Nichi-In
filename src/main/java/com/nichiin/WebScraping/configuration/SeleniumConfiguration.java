package com.nichiin.WebScraping.configuration;

import jakarta.annotation.PostConstruct;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class SeleniumConfiguration {

    private static final String CUSTOM_DOWNLOAD_PATH = System.getProperty("user.home") + "/Desktop/Nichi-in Project/csvHub";

    @PostConstruct
    void postController() {
        System.setProperty("webdriver.chrome.driver", "/Users/pavanp/Desktop/Nichi-in Project/testing/chromedriver");
    }

    @Bean
    public ChromeDriver driver() {

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", CUSTOM_DOWNLOAD_PATH);
        prefs.put("download.prompt_for_download", false); // Disable the download prompt
        prefs.put("safebrowsing.enabled", true);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", List.of("enable-automation"));
        options.setExperimentalOption("prefs", prefs);
        return new ChromeDriver(options);
    }
}
