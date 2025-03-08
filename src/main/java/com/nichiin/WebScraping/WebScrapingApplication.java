package com.nichiin.WebScraping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WebScrapingApplication {

	public static void main(String[] args) {
		if (args.length > 0) {
			System.setProperty("config.xml", args[0]);
		}
		SpringApplication.run(WebScrapingApplication.class, args);
	}

}
