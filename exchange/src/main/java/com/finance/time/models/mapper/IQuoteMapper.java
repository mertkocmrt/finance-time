package com.finance.time.models.mapper;

import com.finance.time.dto.requests.GetQuoteDto;
import com.finance.time.dto.responses.QuoteResponse;
import com.finance.time.models.Quote;

public interface IQuoteMapper {
    Quote dtoToEntity(GetQuoteDto quote);
    QuoteResponse entityToResponse(Quote quote);
}
