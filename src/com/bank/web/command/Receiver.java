package com.bank.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.web.enums.Action;

public class Receiver {	//	Receiver - class 객체, 인스턴스 객체 아님
	public static Command cmd = new Command();			//	초기화 필수

	public static void init(HttpServletRequest request) {
		cmd = Commander.order(request);
	}

}
