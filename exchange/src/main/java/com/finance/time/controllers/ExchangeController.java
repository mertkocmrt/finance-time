package com.finance.time.controllers;

import com.finance.time.dto.requests.CreateExchangeDto;
import com.finance.time.dto.responses.ExchangeResponse;
import com.finance.time.exceptions.BaseException;
import com.finance.time.exceptions.EntityNotFoundException;
import com.finance.time.exceptions.ServiceProviderException;
import com.finance.time.services.IExchangeService;
import com.finance.time.services.impl.ExchangeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("v1/exchanges")
public class ExchangeController {

    private static final Logger LOG = LoggerFactory.getLogger(ExchangeController.class);

    private final IExchangeService exchangeService;

    @Autowired
    public ExchangeController(ExchangeService exchangeService){
        this.exchangeService = exchangeService;
    }

    @PostMapping
    @RequestMapping("transaction")
    public ResponseEntity<ExchangeResponse> createExchange(@RequestBody CreateExchangeDto request) {
        try {
            return ResponseEntity.ok(exchangeService.createExchange(request));
        } catch(ServiceProviderException e){
            throw e;
        }
        catch(Exception e){
            LOG.error("Exchange API hata..",e);
            throw new BaseException();
        }
    }

    @GetMapping
    @RequestMapping(value = "list", params = {"transactionId"})
    public ResponseEntity<ExchangeResponse> exchangeListByTransactionId(@RequestParam(name="transactionId") String transactionId) {
        try{
            return ResponseEntity.ok(exchangeService.getExchangeById(transactionId));
        }  catch(EntityNotFoundException e){
            throw e;
        } catch(Exception e){
            LOG.error("Exchange List API hata..",e);
            throw new BaseException();
        }
    }

    @GetMapping
    @RequestMapping(value = "list", params = {"conversionDate"})
    public ResponseEntity<List<ExchangeResponse>> exchangeListByIConversionDate(@RequestParam(name="conversionDate")  String conversionDate) {
        try{
            return ResponseEntity.ok(exchangeService.getExchangeListByDate(conversionDate));
        } catch(EntityNotFoundException e){
            throw e;
        } catch(Exception e){
            LOG.error("Exchange List API hata..",e);
            throw new BaseException();
        }
    }

}
