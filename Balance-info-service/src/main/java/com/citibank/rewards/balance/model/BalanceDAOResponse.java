package com.citibank.rewards.balance.model;

import lombok.Data;

@Data
public class BalanceDAOResponse {
	private String respCode;
	private String respMsg;
	private String availablepts;
	private String pendingpts;
	private String earnedpts;
}
