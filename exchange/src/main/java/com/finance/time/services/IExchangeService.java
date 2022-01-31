package com.finance.time.services;

import com.finance.time.dto.requests.CreateExchangeDto;
import com.finance.time.dto.responses.ExchangeResponse;

import java.io.IOException;
import java.util.List;

public interface IExchangeService {

    ExchangeResponse createExchange(CreateExchangeDto createExchangeDto);
    ExchangeResponse getExchangeById(String id);
    List<ExchangeResponse> getExchangeListByDate(String conversionDate);
}
