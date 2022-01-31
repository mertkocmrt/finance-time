package com.finance.time.dto.responses;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public class ExchangeResponse extends BaseResponse{
    private String transactionId;
    private BigDecimal sellAmount;
}
