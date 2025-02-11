package com.nichiin.WebScraping.repository;

import com.nichiin.WebScraping.entity.Stocks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stocks, Long> {

}
