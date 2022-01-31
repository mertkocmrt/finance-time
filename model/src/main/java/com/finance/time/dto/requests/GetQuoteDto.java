package com.finance.time.dto.requests;

import lombok.*;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetQuoteDto  implements Serializable {

    private String sellCurrency;
    private String buyCurrency;
}
