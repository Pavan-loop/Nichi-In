package com.nichiin.WebScraping.service;

import com.nichiin.WebScraping.entity.Stocks;
import com.nichiin.WebScraping.mail.MailContent;
import com.nichiin.WebScraping.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProcessToDatabase {

    private final StockRepository stockRepository;
    private final MailContent mailContent;

    public void addToDatabase(List<Stocks> stocks) {
        log.info("Processing to database");
        stockRepository.saveAll(stocks);
        mailContent.sendSuccessMail();
    }
}
