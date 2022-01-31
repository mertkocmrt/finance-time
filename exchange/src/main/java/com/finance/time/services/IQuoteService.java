package com.finance.time.services;

import com.finance.time.dto.responses.QuoteResponse;

public interface IQuoteService {

    QuoteResponse getQuote(String buyCurrency, String sellCurrency);

}
