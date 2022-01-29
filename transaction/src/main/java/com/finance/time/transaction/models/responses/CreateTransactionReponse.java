package com.finance.time.transaction.models.responses;

import com.finance.time.transaction.exceptions.TransactionException;
import com.finance.time.transaction.models.Transaction;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode()
public class CreateTransactionReponse {
    private Transaction transaction;
    private TransactionException exception;
}
