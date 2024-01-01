package com.wizzer.challenge.businesscore.exceptions;


import com.wizzer.challenge.config.ErrorCode;
import com.wizzer.challenge.config.exception.GenericException;

public class AdapterException extends GenericException {

    public AdapterException(ErrorCode ec){ super(ec);}
}
