package com.nichiin.WebScraping.service;

import com.nichiin.WebScraping.entity.Stocks;
import com.nichiin.WebScraping.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProcessToDatabase {

    private final StockRepository stockRepository;

    public void addToDatabase(List<Stocks> stocks) {
        System.out.println("Processing to database");
        stockRepository.saveAll(stocks);
    }
}
