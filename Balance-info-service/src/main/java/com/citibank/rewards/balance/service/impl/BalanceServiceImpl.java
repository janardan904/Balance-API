package com.citibank.rewards.balance.service.impl;

import org.apache.log4j.Logger;

import com.citibank.rewards.balance.dao.BalanceDAO;
import com.citibank.rewards.balance.dao.impl.BalanceDAOImpl;
import com.citibank.rewards.balance.exception.BusinessException;
import com.citibank.rewards.balance.exception.SystemException;
import com.citibank.rewards.balance.model.BalanceDAORequest;
import com.citibank.rewards.balance.model.BalanceDAOResponse;
import com.citibank.rewards.balance.model.BalanceInfo;
import com.citibank.rewards.balance.model.BalanceRequest;
import com.citibank.rewards.balance.model.BalanceResponse;
import com.citibank.rewards.balance.model.StatusBlock;
import com.citibank.rewards.balance.service.BalanceService;

public class BalanceServiceImpl implements BalanceService {
	private final Logger logger=Logger.getLogger(BalanceServiceImpl.class);
	@Override
	public BalanceResponse getBalance(BalanceRequest request) throws BusinessException, SystemException {
		logger.info("Entered into service layer "+request);
		BalanceDAORequest daorequest=new BalanceDAORequest();
		daorequest.setCardNum(request.getCardNum());
		daorequest.setClientId(request.getClientId());
		daorequest.setRequestId(request.getRequestId());
		daorequest.setMsgts(request.getMsgts());
		
		
		BalanceDAO dao=new BalanceDAOImpl();
		BalanceDAOResponse daoresponse=dao.getBalance(daorequest);
		
		//preapre the service response
		BalanceResponse response=new  BalanceResponse();
		StatusBlock statusBlock=new StatusBlock();
		
		statusBlock.setRespCode(daoresponse.getRespCode());
		statusBlock.setRespMsg(daoresponse.getRespMsg());
		
		BalanceInfo balanceinfo=new BalanceInfo();
		balanceinfo.setAvailablepts(daoresponse.getAvailablepts());
		balanceinfo.setEarnedpts(daoresponse.getEarnedpts());
		balanceinfo.setPendingpts(daoresponse.getPendingpts());
		response.setStatusBlock(statusBlock);
		response.setBalanceInfo(balanceinfo);
		logger.info("Exit into service layer "+request);
		return response;
		
	}

}
