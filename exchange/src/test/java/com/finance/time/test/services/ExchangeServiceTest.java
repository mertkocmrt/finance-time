package com.finance.time.test.services;

import com.finance.time.repositories.IExchangeRepository;
import com.finance.time.services.IExchangeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

//@SpringBootTest
public class ExchangeServiceTest {

//    @Autowired
//    IExchangeRepository exchangeRepository;
//
//    @MockBean
//    private IExchangeService exchangeService;
//
//    @BeforeEach
//    public void setUp() {
//        Exchange exchange = Exchange.builder().transactionId("000").build();
//
//        Mockito.when(exchangeRepository.save(exchange))
//                .thenReturn(exchange);
//    }

//    @Test
//    void createExchange_TestNotNull(){
//        Exchange exchange = Exchange.builder().transactionId("000").build();
//        Exchange createdExchange = exchangeService.createExchange(exchange);
//        assertEquals(exchange.getQuoteId(), createdExchange.getTransactionId());
//    }
}
