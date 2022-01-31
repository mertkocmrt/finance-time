package com.finance.time.models.mapper.impl;

import com.finance.time.dto.requests.GetQuoteDto;
import com.finance.time.dto.responses.QuoteResponse;
import com.finance.time.models.Quote;
import com.finance.time.models.mapper.IQuoteMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuoteMapper implements IQuoteMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public QuoteMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    @Override
    public Quote dtoToEntity(GetQuoteDto quote) {
        return modelMapper.map(quote, Quote.class);
    }

    @Override
    public QuoteResponse entityToResponse(Quote quote) {
        return modelMapper.map(quote, QuoteResponse.class);
    }
}
