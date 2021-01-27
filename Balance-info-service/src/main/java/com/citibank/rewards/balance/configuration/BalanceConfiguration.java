package com.citibank.rewards.balance.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("com.citibank.rewards.balance.controller")
public class BalanceConfiguration {
	
	

}
