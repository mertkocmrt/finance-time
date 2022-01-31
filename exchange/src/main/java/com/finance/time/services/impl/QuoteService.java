package com.finance.time.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.finance.time.dto.responses.QuoteResponse;
import com.finance.time.exceptions.BaseException;
import com.finance.time.exceptions.EntityNotFoundException;
import com.finance.time.exceptions.ServiceProviderException;
import com.finance.time.models.Quote;
import com.finance.time.models.mapper.IQuoteMapper;
import com.finance.time.models.mapper.impl.QuoteMapper;
import com.finance.time.services.IQuoteService;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Objects;

@Service
public class QuoteService implements IQuoteService {

    private static final Logger LOG = LoggerFactory.getLogger(QuoteService.class);

    private final IQuoteMapper quoteMapper;

    public QuoteService(QuoteMapper quoteMapper){
        this.quoteMapper = quoteMapper;
    }

    @Override
    public QuoteResponse getQuote(String buyCurrency, String sellCurrency) {
        try {
            OkHttpClient client = new OkHttpClient();

            String url = "http://data.fixer.io/api/latest";
            HttpUrl.Builder httpBuilder = Objects.requireNonNull(HttpUrl.parse(url)).newBuilder();
            httpBuilder.addQueryParameter("access_key", "1372abad00d2c52203c0c9ab9ac00f63")
                    .addQueryParameter("base", sellCurrency)
                    .addQueryParameter("symbols", buyCurrency);

            Request request = new Request.Builder()
                    .url(httpBuilder.build())
                    .get()
                    .addHeader("Accept", "application/json")
                    .build();

            Response response = client.newCall(request).execute();

            ObjectMapper objectMapper = new ObjectMapper();
            String json = Objects.requireNonNull(response.body()).string();
            Quote quote = objectMapper.readValue(json, Quote.class);

            return quoteMapper.entityToResponse(quote);
        } catch(IOException e){
            LOG.error("Quote Service getQuote hatası - IOException");
            throw new ServiceProviderException();
        }
    }


}
