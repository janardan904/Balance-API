package com.citibank.rewards.balance.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.citibank.rewards.balance.exception.BalanceRequestInvalidDataException;
import com.citibank.rewards.balance.exception.BusinessException;
import com.citibank.rewards.balance.exception.SystemException;
import com.citibank.rewards.balance.model.ErrorResponse;
import com.citibank.rewards.balance.model.StatusBlock;

@RestControllerAdvice
public class BalanceExceptionHandler {
	private Logger logger=Logger.getLogger(BalanceExceptionHandler.class);
	
	@ExceptionHandler(value=BalanceRequestInvalidDataException.class)
	public ErrorResponse handleRequestInvalidException(BalanceRequestInvalidDataException e) {
		logger.error(" BalanceRequestInvalidDataException occoured ",e);
		ErrorResponse response=buildErrorResp(e.getRespCode(),e.getRespMsg());
		return response;
		
	}
	@ExceptionHandler(value=BusinessException.class)
public ErrorResponse handleDataErrors(BusinessException e) {
		logger.error(" BusinessException occoured ",e);
		ErrorResponse response=buildErrorResp(e.getRespCode(),e.getRespMsg());
	
	return response;
	
	
}
	@ExceptionHandler(value=SystemException.class)
public ErrorResponse handleDataErrors(SystemException e) {
		logger.error(" SystemException occoured ",e);
		ErrorResponse response=buildErrorResp(e.getRespCode(),e.getRespMsg());
	return response;
}
	@ExceptionHandler(value=Exception.class)
	public ErrorResponse handleGenericErrors(Exception e) {
		logger.fatal(" Exception occoured ",e);
		ErrorResponse response=buildErrorResp("2222","unknown error fronm database"+e.getMessage());
		return response;
		
	}

private ErrorResponse buildErrorResp(String respCode,String respMsg) {
ErrorResponse response=new ErrorResponse();
	
	StatusBlock statusBlock = new StatusBlock();
	statusBlock.setRespCode(respCode);
	statusBlock.setRespCode(respMsg);
	response.setStatusBlock(statusBlock);
	return response;
	
}
}
