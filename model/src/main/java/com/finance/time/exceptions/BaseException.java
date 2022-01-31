package com.finance.time.exceptions;

import com.finance.time.common.ExceptionEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BaseException extends RuntimeException {

    private final String message;

    public BaseException() {
        this.message = ExceptionEnum.INTERNAL_SERVER_ERROR.getValue();
    }

    public BaseException(String message) {
        this.message = message;

    }
}
