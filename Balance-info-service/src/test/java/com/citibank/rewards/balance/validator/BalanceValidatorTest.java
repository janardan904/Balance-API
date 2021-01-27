package com.citibank.rewards.balance.validator;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.citibank.rewards.balance.exception.BalanceRequestInvalidDataException;
import com.citibank.rewards.balance.model.BalanceRequest;

public class BalanceValidatorTest {
	BalanceRequest request=null;
	@Before
	public void setUp() throws Exception {
		buildRequest();
		
	}
	private void buildRequest() {
		request=new BalanceRequest();
		request.setCardNum("12345456677");
		request.setClientId("web");
		request.setRequestId("2232323");
		request.setMsgts("21-01-2021");
	}
	@Test
	public void testcardNumber_NUll_scenerio() {
		
		request.setCardNum(null);	
	BalanceValidator validator=new BalanceValidator();
	try {
		validator.validateRequest(request);
	} catch (BalanceRequestInvalidDataException e) {
		
	assertEquals(null,e.getMessage());
	}
	}
	@Test
	public void testcardNumber_NUll_Empty_scenerio() {	
	 BalanceRequest request=new BalanceRequest();
		request.setCardNum("");
		request.setClientId("web");
		request.setRequestId("2232323");
		request.setMsgts("21-01-2021");
	BalanceValidator validator=new BalanceValidator();
	try {
		validator.validateRequest(request);
	} catch (BalanceRequestInvalidDataException e) {
		
		assertEquals(null,e.getMessage());
	}
	}
	
	@Test
	public void testClientId_NUll_scenerio() {	
	 request.setClientId(null);
	BalanceValidator validator=new BalanceValidator();
	try {
		validator.validateRequest(request);
	} catch (BalanceRequestInvalidDataException e) {
		assertEquals(null,e.getMessage());
		
	}
	}
	@Test
	public void testClientId_NUll_Empty_scenerio() {
		
		
	 BalanceRequest request=new BalanceRequest();
		request.setCardNum("12345456677");
		request.setClientId(" ");
		request.setRequestId("2232323");
		request.setMsgts("21-01-2021");
	BalanceValidator validator=new BalanceValidator();
	try {
		validator.validateRequest(request);
	} catch (BalanceRequestInvalidDataException e) {
		
		assertEquals(null,e.getMessage());
	}

	}
	@Test
	public void testRequestId_NUll_scenerio() {	
		request.setRequestId(null);
	 BalanceRequest request=new BalanceRequest();
	 
		request.setCardNum("12345456677");
		request.setClientId("web");
		request.setMsgts("21-01-2021");
	BalanceValidator validator=new BalanceValidator();
	try {
		validator.validateRequest(request);
	} catch (BalanceRequestInvalidDataException e) {
		
		assertEquals(null,e.getMessage());
	}
	}

	@Test
	public void testRequestId_NUll_Empty_scenerio() {
		 
	 BalanceRequest request=new BalanceRequest();
	 request.setRequestId("");
		request.setCardNum("12345456677");
		request.setClientId("web");
		request.setMsgts("21-01-2021");
	BalanceValidator validator=new BalanceValidator();
	try {
		validator.validateRequest(request);
	} catch (BalanceRequestInvalidDataException e) {
		
		assertEquals(null,e.getMessage());
	}
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
}
