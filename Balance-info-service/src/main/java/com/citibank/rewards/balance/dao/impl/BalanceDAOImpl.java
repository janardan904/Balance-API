package com.citibank.rewards.balance.dao.impl;

import org.apache.log4j.Logger;

import com.citibank.rewards.balance.dao.BalanceDAO;
import com.citibank.rewards.balance.exception.BusinessException;
import com.citibank.rewards.balance.exception.SystemException;
import com.citibank.rewards.balance.model.BalanceDAORequest;
import com.citibank.rewards.balance.model.BalanceDAOResponse;

public class BalanceDAOImpl implements BalanceDAO {
private final Logger logger=Logger.getLogger(BalanceDAOImpl.class);
	@Override
	public BalanceDAOResponse getBalance(BalanceDAORequest daorequest) throws BusinessException, SystemException {
		
		logger.info("Enetered into dao:"+daorequest);
		 BalanceDAOResponse daoresp=new  BalanceDAOResponse();
		 String env=System.getProperty("env");
		 String fileName="properties/balance-"+env+"-db.properties";
		 logger.info("env:  "+env+"fileName:"+fileName);
		   
		 try {
		 String respCode="0";
		   String respMsg="success";
		 if("0".equals(respCode)) {
			 daoresp.setRespCode("0");
			 daoresp.setRespMsg("success");
		 
		
         daoresp.setRespMsg("sucess");
         daoresp.setAvailablepts("1000");
         daoresp.setPendingpts("5000");
         daoresp.setEarnedpts("10000");
	}
         
         else if("100".equals(respCode) || ("101").equals(respCode)||("102").equals(respCode)|| ("103".equals(respCode))){
        	 throw new BusinessException(respCode,respMsg);
        	
         }
         
         else {
        	 throw new SystemException(respCode,respMsg);
         }
		 
		 }
		 catch(BusinessException e) {
			 logger.error(e.getRespCode()+" "+e.getRespMsg());
			 throw e;
		 }
		 
		 catch(SystemException e) {
			 logger.error(e.getRespCode()+" "+e.getRespMsg());
			 throw e;
		 }
		 catch(Exception e) {
			 logger.fatal("Exception in DAO layer");
			 throw new SystemException("1111","Unknown  error from Database");
		 }
		 
          logger.info("exit into dao layer response to sarvice layer"+daoresp);		
		return daoresp;
	}
	 
}
