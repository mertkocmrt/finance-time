package com.finance.time.models;

import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Quote implements Serializable {

    private Boolean success;
    private Long timestamp;
    private String base;
    private String date;
    private Map<String,Double> rates;


}
