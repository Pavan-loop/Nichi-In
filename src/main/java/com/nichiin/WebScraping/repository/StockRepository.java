package com.nichiin.WebScraping.repository;

import com.nichiin.WebScraping.entity.Stocks;
import com.nichiin.WebScraping.restConfiguration.DTO.StocksDateDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StockRepository extends JpaRepository<Stocks, Long> {

    @Query("SELECT DISTINCT s.date FROM Stocks s ORDER BY s.date")
    List<String> getDistinctDate();
    List<Stocks> findByDate(String date);
}
