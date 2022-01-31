package com.finance.time.test.services;

import com.finance.time.dto.requests.CreateExchangeDto;
import com.finance.time.dto.responses.ExchangeResponse;
import com.finance.time.dto.responses.QuoteResponse;
import com.finance.time.models.Exchange;
import com.finance.time.models.mapper.impl.ExchangeMapper;
import com.finance.time.repositories.IExchangeRepository;
import com.finance.time.services.impl.ExchangeService;
import com.finance.time.services.impl.QuoteService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ExchangeServiceTest {

    @InjectMocks
    ExchangeService exchangeService;

    @Mock
    QuoteService quoteService;
    @Mock
    ExchangeMapper exchangeMapper;
    @Mock
    QuoteResponse quoteResponse;
    @Mock
    ExchangeResponse exchangeResponse;
    @Mock
    Exchange exchange;
    @Mock
    IExchangeRepository exchangeRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createEmployeeTest()
    {
        Mockito.when(quoteService.getQuote(any(),any())).thenReturn(quoteResponse);
        Mockito.when(exchangeRepository.save(any())).thenReturn(exchange);
        Mockito.when(exchangeMapper.entityToResponse(any(Exchange.class))).thenReturn(exchangeResponse);

        CreateExchangeDto createExchangeDto = CreateExchangeDto.builder().build();
        exchangeService.createExchange(createExchangeDto);

        verify(quoteService, times(1)).getQuote(any(),any());
        verify(exchangeRepository, times(1)).save(any());
    }

    @Test
    public void getExchangeByIdTest()
    {
        Mockito.when(exchangeRepository.findById(any())).thenReturn(Optional.of(exchange));
        Mockito.when(exchangeMapper.entityToResponse(any(Exchange.class))).thenReturn(exchangeResponse);

        exchangeService.getExchangeById("ID");

        verify(exchangeRepository, times(1)).findById(any());
        verify(exchangeMapper, times(1)).entityToResponse(any(Exchange.class));
    }

    @Test
    public void getExchangeByDateTest()
    {
        List<Exchange> exchange = new ArrayList<>();
        exchange.add(Exchange.builder().quoteDate("yyyy-mm-dd").build());
        Mockito.when(exchangeRepository.findByQuoteDate(any())).thenReturn(exchange);
        Mockito.when(exchangeMapper.entityToResponse(any(Exchange.class))).thenReturn(exchangeResponse);

        exchangeService.getExchangeListByDate("ID");

        verify(exchangeRepository, times(1)).findByQuoteDate(any());
        verify(exchangeMapper, times(1)).entityToResponse(any(List.class));
    }

}
