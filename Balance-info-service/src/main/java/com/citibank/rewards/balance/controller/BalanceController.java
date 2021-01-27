package com.citibank.rewards.balance.controller;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.citibank.rewards.balance.exception.BalanceRequestInvalidDataException;
import com.citibank.rewards.balance.exception.BusinessException;
import com.citibank.rewards.balance.exception.SystemException;
import com.citibank.rewards.balance.model.BalanceRequest;
import com.citibank.rewards.balance.model.BalanceResponse;
import com.citibank.rewards.balance.service.BalanceService;
import com.citibank.rewards.balance.service.impl.BalanceServiceImpl;
import com.citibank.rewards.balance.validator.BalanceValidator;
@RestController
public class BalanceController {
	private final Logger logger=Logger.getLogger(BalanceController.class);
	
	
	
	@RequestMapping(method=RequestMethod.GET,value="/balance/{cardNum}",produces="application/json")
	public BalanceResponse getBalance(@PathVariable("cardNum") String cardNum,
	                                  @RequestHeader("client-id")String clientId,
	                                  @RequestHeader("request-id")String requestId,
	                                  @RequestHeader("msg-ts")String msgts) throws BalanceRequestInvalidDataException, BusinessException, SystemException {
		
		logger.info("enterd int controller request");
		
		//prepare thee balance request
		BalanceRequest request =new BalanceRequest();
		request.setCardNum(cardNum);
		request.setClientId(clientId);
		request.setRequestId(requestId);
		request.setMsgts(msgts);
		
		//validate the request
		
		BalanceValidator validator=new BalanceValidator();
		
			validator.validateRequest(request);
		
		//call service layer
		BalanceService service=new BalanceServiceImpl();
	    BalanceResponse response=service.getBalance(request);
	    logger.info("exit into controller request");
	    return response;
		
	}

}
