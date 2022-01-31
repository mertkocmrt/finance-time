package com.finance.time.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "exchanges")
public class Exchange {

    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String transactionId;

    @Column(name = "quote_id", nullable = false)
    private Long quoteId;
    @Column(nullable = false)
    private Double quote;
    @Column(name = "buy_currency", nullable = false)
    private String buyCurrency;
    @Column(name = "sell_currency", nullable = false)
    private String sellCurrency;
    @Column(name = "buy_amount", nullable = false)
    private BigDecimal buyAmount;
    @Column(name = "sell_amount", nullable = false)
    private BigDecimal sellAmount;
    @Column(name = "quote_date", nullable = false)
    private String quoteDate;
    @Column(name = "transaction_date", nullable = false)
    private String transactionDate;

}
