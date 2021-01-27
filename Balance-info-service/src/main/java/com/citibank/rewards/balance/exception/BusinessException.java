package com.citibank.rewards.balance.exception;

public class BusinessException extends Exception {
	
	 private String  respCode;
	 private String respMsg;
	public BusinessException(String respCode, String respMsg) {
		
	}
	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public String getRespMsg() {
		return respMsg;
	}
	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}
	
	

}
