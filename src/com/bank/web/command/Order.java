package com.bank.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Order {
	public void execute()throws Exception;
	
}
