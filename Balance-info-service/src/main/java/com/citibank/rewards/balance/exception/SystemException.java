package com.citibank.rewards.balance.exception;

public class SystemException extends Exception {
	
	private String respCode;
	private String respMsg;

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

	public SystemException(String respCode, String respMsg) {
		
	}
	

}
