package com.nichiin.WebScraping.configuration;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class CsvPathConfig {

    private String customCsvPath;

    public void setCustomCsvPath(String customCsvPath) {
        this.customCsvPath = customCsvPath;
    }
}
