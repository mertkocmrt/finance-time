package com.finance.time.controllers;

import com.finance.time.dto.responses.QuoteResponse;
import com.finance.time.services.IQuoteService;
import com.finance.time.services.impl.QuoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("v1/quotes")
public class QuoteController {

    private static final Logger LOG = LoggerFactory.getLogger(QuoteController.class);

    private final IQuoteService quoteService;

    @Autowired
    public QuoteController(QuoteService quoteService){
        this.quoteService = quoteService;
    }

    @GetMapping
    @RequestMapping("rate")
    public ResponseEntity<QuoteResponse> getQuote(@RequestParam(name = "sellCurrency") String sellCurrency,
                                                  @RequestParam(name = "buyCurrency") String buyCurrency) {
        try {
            return ResponseEntity.ok(quoteService.getQuote(sellCurrency,buyCurrency));
        } catch(Exception e){
            LOG.error("Exchange rate API hata..",e);
            throw e;
        }
    }
}
