package com.nichiin.WebScraping.scheduler;

import com.nichiin.WebScraping.entity.Stocks;
import com.nichiin.WebScraping.service.DownloadCsvService;
import com.nichiin.WebScraping.service.ProcessToDatabase;
import com.nichiin.WebScraping.service.ReadCsvService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Manager {

    private final DownloadCsvService downloadCsvService;
    private final ReadCsvService readCsvService;
    private final ProcessToDatabase processToDatabase;


    @PostConstruct
    public void startTheProcess() {
        System.out.println("Main method is called");
        String filePath = downloadCsvService.scrapeTableData();
        if (!filePath.isEmpty()) {
            List<Stocks> stocks = readCsvService.readCsv(filePath);
            processToDatabase.addToDatabase(stocks);
        }
    }

}
