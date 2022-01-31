package com.finance.time.services;

import com.finance.time.dto.responses.QuoteResponse;
import org.springframework.stereotype.Service;

@Service
public interface IQuoteService {

    QuoteResponse getQuote(String buyCurrency, String sellCurrency);

}
