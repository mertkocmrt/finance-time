package com.finance.time.dto.requests;


import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateExchangeDto implements Serializable {

    private BigDecimal buyAmount;
    private String buyCurrency;
    private String sellCurrency;

    @Builder.Default
    private String transactionDate = new SimpleDateFormat("yyyy-mm-dd").format(new Date());
}
