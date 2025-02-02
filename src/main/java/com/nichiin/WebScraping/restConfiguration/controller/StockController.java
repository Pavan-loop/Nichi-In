package com.nichiin.WebScraping.restConfiguration.controller;

import com.nichiin.WebScraping.restConfiguration.DTO.StocksDTO;
import com.nichiin.WebScraping.restConfiguration.DTO.StocksDateDTO;
import com.nichiin.WebScraping.restConfiguration.service.StocksService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/stocks")
public class StockController {

    private final StocksService stocksService;

    @GetMapping("/date")
    public ResponseEntity<List<StocksDateDTO>> getDistinctDateOfAvailableStocks() {
        return new ResponseEntity<>(stocksService.getDateOfAvailableStockData(), HttpStatus.OK);
    }

    @GetMapping("/{dateVal}")
    public ResponseEntity<List<StocksDTO>> getStocksByDate(
            @PathVariable String dateVal
    ) {
        return new ResponseEntity<>(stocksService.selectStock(dateVal), HttpStatus.OK);
    }
}
