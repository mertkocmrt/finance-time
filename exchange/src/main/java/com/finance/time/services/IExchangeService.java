package com.finance.time.services;

import com.finance.time.dto.requests.CreateExchangeDto;
import com.finance.time.dto.responses.ExchangeResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IExchangeService {

    ExchangeResponse createExchange(CreateExchangeDto createExchangeDto);
    ExchangeResponse getExchangeById(String id);
    List<ExchangeResponse> getExchangeListByDate(String conversionDate);
}
