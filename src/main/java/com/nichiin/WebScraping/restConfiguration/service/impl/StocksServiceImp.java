package com.nichiin.WebScraping.restConfiguration.service.impl;

import com.nichiin.WebScraping.entity.Stocks;
import com.nichiin.WebScraping.repository.StockRepository;
import com.nichiin.WebScraping.restConfiguration.DTO.StocksDTO;
import com.nichiin.WebScraping.restConfiguration.DTO.StocksDateDTO;
import com.nichiin.WebScraping.restConfiguration.service.StocksService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StocksServiceImp implements StocksService {

    private final StockRepository stockRepository;


    @Override
    public List<StocksDateDTO> getDateOfAvailableStockData() {
        List<String> listOfDate = stockRepository.getDistinctDate();

        return listOfDate.stream()
                .map(date -> StocksDateDTO.builder()
                        .date(date)
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<StocksDTO> selectStock(String date) {
        List<Stocks> listOfStocksOnParticularDate = stockRepository.findByDate(date);

        System.out.println(listOfStocksOnParticularDate.toString());

        return listOfStocksOnParticularDate.stream()
                .map(stock -> StocksDTO.builder()
                        .stockName(stock.getStockName())
                        .prev_close(stock.getPrev_close())
                        .iep(stock.getIep())
                        .chng(stock.getChng())
                        .perChng(stock.getPerChng())
                        .finaal(stock.getFinaal())
                        .finalQuality(stock.getFinalQuality())
                        .value(stock.getValue())
                        .ffmcap(stock.getFfmcap())
                        .nm52wh(stock.getNm52wh())
                        .nm52wl(stock.getNm52wl())
                        .build())
                .collect(Collectors.toList());
    }
}
