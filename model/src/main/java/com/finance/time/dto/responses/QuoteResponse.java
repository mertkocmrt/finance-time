package com.finance.time.dto.responses;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
public class QuoteResponse extends BaseResponse{

    private Boolean success;
    private Long timestamp;
    private String base;
    private String date;
    private Map<String,Double> rates;
    private BigDecimal sellAmount;

}
