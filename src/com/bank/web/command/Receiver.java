package com.bank.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Receiver {
	public static Command cmd = new Command();
	public static void init(HttpServletRequest request) {
		try {
			cmd = new MoveCommand(request);	//	다형성
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
