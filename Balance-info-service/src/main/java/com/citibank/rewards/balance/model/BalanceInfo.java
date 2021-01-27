package com.citibank.rewards.balance.model;

import lombok.Data;

@Data
public class BalanceInfo {
	private String availablepts;
	private String pendingpts;
	private String earnedpts;

}
