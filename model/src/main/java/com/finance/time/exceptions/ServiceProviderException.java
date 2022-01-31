package com.finance.time.exceptions;

import com.finance.time.common.ExceptionEnum;

public class ServiceProviderException extends BaseException{

    public ServiceProviderException(){
        super(ExceptionEnum.SERVICE_PROVIDER_ERROR.getValue());
    }
}
