package com.finance.time.services.impl;

import com.finance.time.dto.requests.CreateExchangeDto;
import com.finance.time.dto.responses.ExchangeResponse;
import com.finance.time.dto.responses.QuoteResponse;
import com.finance.time.exceptions.EntityNotFoundException;
import com.finance.time.exceptions.ServiceProviderException;
import com.finance.time.models.Exchange;
import com.finance.time.models.mapper.IExchangeMapper;
import com.finance.time.models.mapper.impl.ExchangeMapper;
import com.finance.time.repositories.IExchangeRepository;
import com.finance.time.services.IExchangeService;
import com.finance.time.services.IQuoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ExchangeService implements IExchangeService {

    private static final Logger LOG = LoggerFactory.getLogger(ExchangeService.class);

    private final IExchangeRepository exchangeRepository;
    private final IExchangeMapper exchangeMapper;
    private final IQuoteService quoteService;

    @Autowired
    public ExchangeService(IExchangeRepository exchangeRepository, ExchangeMapper exchangeMapper, QuoteService quoteService){
        this.exchangeRepository = exchangeRepository;
        this.exchangeMapper = exchangeMapper;
        this.quoteService = quoteService;
    }

    @Override
    public ExchangeResponse createExchange(CreateExchangeDto request) throws ServiceProviderException{
        try {
            QuoteResponse quoteResponse = quoteService.getQuote(request.getBuyCurrency(), request.getSellCurrency());
            Exchange exchange = mapToExchange(request, quoteResponse);
            Exchange insertedExchange = exchangeRepository.save(exchange);
            return exchangeMapper.entityToResponse(insertedExchange);
        } catch(Exception e){
            LOG.error("Exchange Service createExchange hatası");
            throw e;
        }
    }

    @Override
    public ExchangeResponse getExchangeById(String transactionId) {
        try {
            Optional<Exchange> exchange = exchangeRepository.findById(transactionId);

            if (!exchange.isPresent()) {
                throw new EntityNotFoundException();
            }

            return exchangeMapper.entityToResponse(exchange.get());
        } catch(EntityNotFoundException e){
            LOG.error("Exchange Service getExchangeById hatası - EntityNotFoundException");
            throw e;
        } catch(Exception e){
            LOG.error("Exchange Service getExchangeById hatası");
            throw e;
        }
    }

    @Override
    public List<ExchangeResponse> getExchangeListByDate(String conversionDate){
        try {
            List<Exchange> exchange = exchangeRepository.findByQuoteDate(conversionDate);

            if(!exchange.isEmpty()){
                throw new EntityNotFoundException();
            }

            return exchangeMapper.entityToResponse(exchange);
        } catch(EntityNotFoundException e){
            LOG.error("Exchange Service getExchangeListByDate hatası - EntityNotFoundException");
            throw e;
        } catch(Exception e){
            LOG.error("Exchange Service getExchangeListByDate hatası");
            throw e;
        }
    }

    private BigDecimal calculateSellAmount(BigDecimal buyAmount, Double rate){
        return buyAmount.multiply(BigDecimal.valueOf(rate));
    }

    private Exchange mapToExchange(CreateExchangeDto createExchangeDto, QuoteResponse quote) {
        Exchange exchange = exchangeMapper.dtoToEntity(createExchangeDto);

        if(quote != null && quote.getRates() != null){
            exchange.setQuote(quote.getRates().get(exchange.getBuyCurrency()));
            exchange.setSellAmount(calculateSellAmount(exchange.getBuyAmount(),exchange.getQuote()));
            exchange.setQuoteDate(quote.getDate());
            exchange.setQuoteId(quote.getTimestamp());
        }
        return exchange;
    }

}
