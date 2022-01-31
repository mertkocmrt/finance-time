package com.finance.time.models.mapper.impl;

import com.finance.time.dto.requests.CreateExchangeDto;
import com.finance.time.dto.responses.ExchangeResponse;
import com.finance.time.models.Exchange;
import com.finance.time.models.mapper.IExchangeMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExchangeMapper implements IExchangeMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public ExchangeMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    @Override
    public Exchange dtoToEntity(CreateExchangeDto createExchangeDto) {
        return modelMapper.map(createExchangeDto, Exchange.class);
    }

    @Override
    public ExchangeResponse entityToResponse(Exchange exchange) {
        return exchange != null ? modelMapper.map(exchange, ExchangeResponse.class) : new ExchangeResponse();
    }

    @Override
    public List<ExchangeResponse> entityToResponse(List<Exchange> exchangeList) {
        return exchangeList != null ? modelMapper.map(exchangeList, List.class) : new ArrayList<ExchangeResponse>();
    }
}
