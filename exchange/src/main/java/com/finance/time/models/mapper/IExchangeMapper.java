package com.finance.time.models.mapper;

import com.finance.time.dto.requests.CreateExchangeDto;
import com.finance.time.dto.responses.ExchangeResponse;
import com.finance.time.models.Exchange;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IExchangeMapper {
    Exchange dtoToEntity(CreateExchangeDto exchange);
    ExchangeResponse entityToResponse(Exchange createExchangeDto);
    List<ExchangeResponse> entityToResponse(List<Exchange> createExchangeDto);
}
