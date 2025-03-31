package com.nichiin.WebScraping.scheduler;

import com.nichiin.WebScraping.configuration.CheckConfig;
import com.nichiin.WebScraping.configuration.XMLMapperConfiguration;
import com.nichiin.WebScraping.entity.Stocks;
import com.nichiin.WebScraping.service.DownloadCsvService;
import com.nichiin.WebScraping.service.ProcessToDatabase;
import com.nichiin.WebScraping.service.ReadCsvService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class Manager {

    private final DownloadCsvService downloadCsvService;
    private final ReadCsvService readCsvService;
    private final ProcessToDatabase processToDatabase;
    private final CheckConfig checkConfig;


    @PostConstruct
    public void startTheProcess() {
        log.info("Main method is called");
        String filePath = downloadCsvService.scrapeTableData();
        if (!filePath.isEmpty()) {
            List<Stocks> stocks = readCsvService.readCsv(filePath);
            processToDatabase.addToDatabase(stocks);
        }
    }

}
