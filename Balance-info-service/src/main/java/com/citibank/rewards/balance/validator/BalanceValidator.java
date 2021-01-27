package com.citibank.rewards.balance.validator;

import org.apache.log4j.Logger;

import com.citibank.rewards.balance.exception.BalanceRequestInvalidDataException;
import com.citibank.rewards.balance.model.BalanceRequest;

public class BalanceValidator {
     private final  Logger logger=Logger.getLogger(BalanceValidator.class);
	public void validateRequest(BalanceRequest request) throws BalanceRequestInvalidDataException {
		
		//TO:DO validate the request ,throws user defiend exceptions if any invalid data
		
		if(request.getCardNum()==null|| " ".equals(request.getCardNum())) {
			throw new BalanceRequestInvalidDataException("bloo1","invalid cardNum");
		}
		if(request.getClientId()==null  ||" ".equals(request.getClientId())) {
			throw new BalanceRequestInvalidDataException("bloo2","invalid clientId");
			
		}
		
		if(request.getRequestId()==null || "".equals(request.getRequestId())) {
			throw new BalanceRequestInvalidDataException("bloo3","invalid requestId");
			
		}
		
		if(request.getMsgts()==null || "".equals(request.getMsgts())) {
			throw new BalanceRequestInvalidDataException("bloo3","invalid mgsts");
		}
		
	}

}
