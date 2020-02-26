package com.cts.training.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cts.training.model.StockExchange;

public interface StockExchangeRepo extends JpaRepository<StockExchange, Integer>{

}
