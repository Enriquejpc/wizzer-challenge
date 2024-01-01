package com.wizzer.challenge.businesscore.exceptions;


import com.wizzer.challenge.config.ErrorCode;

public class NotFoundException extends BusinessException {
    public NotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}