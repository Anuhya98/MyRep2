package com.cts.training.stockpriceservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StockPriceRepo extends JpaRepository<StockPrice, Integer>{

}
