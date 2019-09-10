package com.bank.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.web.pool.Constants;

public class Sender {	//	Sender는 class 객체로 disk에 저장
	public static void forward(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("캐리어 내부 : " + Receiver.cmd.getView() + "\n");
		try {
			request.getRequestDispatcher(Receiver.cmd.getView())
					.forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("sender 동작");
	}
}
