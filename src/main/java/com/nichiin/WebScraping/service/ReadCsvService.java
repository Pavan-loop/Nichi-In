package com.nichiin.WebScraping.service;

import com.nichiin.WebScraping.entity.Stocks;
import com.opencsv.CSVReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReadCsvService {
    public List<Stocks> readCsv(String filePath) {
        log.info("Reading CSV File");
        List<Stocks> stocks = new ArrayList<>();

        try(CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();

            boolean isFirstRow = true;

            for (String[] record : records) {
                if (isFirstRow) {
                    isFirstRow = false;
                    continue;
                }
                var stk = Stocks.builder()
                        .symbol(record[0])
                        .prev_close(record[1])
                        .iep(record[2])
                        .chng(record[3])
                        .perChng(record[4])
                        .finaal(record[5])
                        .finalQuality(record[6])
                        .value(record[7])
                        .ffmcap(record[8])
                        .nm52wh(record[9])
                        .nm52wl(record[10])
                        .dt(getDateTime().substring(0,8))
                        .updateSource("autoscript")
                        .updateTime(getDateTime())
                        .build();

                stocks.add(stk);
            }

        }catch (Exception e) {
            log.error("Error while reading csv file: {}", e.getMessage());
        }

        for (Stocks str : stocks) {
            System.out.println(str);
        }
        return stocks;
    }

    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        return dateFormat.format(new Date()).toLowerCase();
    }
}
