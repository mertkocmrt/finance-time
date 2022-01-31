package com.finance.time.config;

import com.finance.time.dto.responses.BaseResponse;
import com.finance.time.exceptions.BaseException;
import com.finance.time.exceptions.EntityNotFoundException;
import com.finance.time.exceptions.ServiceProviderException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Locale;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({EntityNotFoundException.class})
    protected ResponseEntity<BaseResponse> handleNotFoundException(EntityNotFoundException e, Locale locale) {
        return ResponseEntity
                .badRequest()
                .body(BaseResponse.builder().responseMessage(e.getMessage()).build());
    }

    @ExceptionHandler({ServiceProviderException.class})
    protected ResponseEntity<BaseResponse>  handleServiceProviderException(ServiceProviderException e, Locale locale) {
        return ResponseEntity
                .badRequest()
                .body(BaseResponse.builder().responseMessage(e.getMessage()).build());
    }

    @ExceptionHandler(BaseException.class)
    protected ResponseEntity<BaseResponse>  handleOtherException (BaseException e, Locale locale) {
        return ResponseEntity
                .internalServerError()
                .body(BaseResponse.builder().responseMessage(e.getMessage()).build());
    }

}
