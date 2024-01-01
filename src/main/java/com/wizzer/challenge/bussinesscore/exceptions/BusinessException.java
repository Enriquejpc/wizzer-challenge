package com.wizzer.challenge.bussinesscore.exceptions;


import com.wizzer.challenge.config.ErrorCode;
import com.wizzer.challenge.config.exception.GenericException;

public class BusinessException extends GenericException {

	public BusinessException(ErrorCode errorCode){
		super(errorCode);
	}
}
