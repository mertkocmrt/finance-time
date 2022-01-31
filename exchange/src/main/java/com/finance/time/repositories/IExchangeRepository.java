package com.finance.time.repositories;

import com.finance.time.models.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IExchangeRepository extends JpaRepository<Exchange, String> {
    List<Exchange> findByQuoteDate(String conversionDate);
}
