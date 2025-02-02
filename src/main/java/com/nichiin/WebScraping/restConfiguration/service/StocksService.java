package com.nichiin.WebScraping.restConfiguration.service;

import com.nichiin.WebScraping.entity.Stocks;
import com.nichiin.WebScraping.restConfiguration.DTO.StocksDTO;
import com.nichiin.WebScraping.restConfiguration.DTO.StocksDateDTO;

import java.util.Date;
import java.util.List;

public interface StocksService {
    List<StocksDateDTO> getDateOfAvailableStockData();
    List<StocksDTO> selectStock(String date);
}
