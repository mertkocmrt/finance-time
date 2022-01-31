package com.finance.time.exceptions;

import com.finance.time.common.ExceptionEnum;

public class EntityNotFoundException  extends BaseException {

    public EntityNotFoundException(){
        super(ExceptionEnum.ERROR_ENTITY_NOT_FOUND.getValue());
    }

}
