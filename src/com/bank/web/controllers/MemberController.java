package com.bank.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.web.command.Sender;
import com.bank.web.command.Command;
import com.bank.web.command.MoveCommand;
import com.bank.web.command.Order;
import com.bank.web.command.Receiver;
import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.MemberBean;
import com.bank.web.pool.Constants;
import com.bank.web.services.MemberService;
import com.bank.web.servicesimpl.MemberServiceImpl;

@WebServlet("/customer.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  //  public MemberController() {
  //      super();	// super() : HttpServlet, 부모의 생성자  
  //  }
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 역직렬화
		System.out.println("맥락이 맞아서 여기 도착");    
		//	RequestDispatcher rd = null;
		// 데이터 저장이 안됨.

		Receiver.init(request);
		System.out.println("Receiver.init 종료");
		System.out.println("Receiver.init 종료 후 page : " + request.getParameter("page"));
		Receiver.cmd.execute();
		System.out.println("---------------------------------------");
		System.out.println("컨트롤러 샌더 시작 전");
		System.out.println( "page : "+ request.getParameter("page"));
		System.out.println( "action : "+ request.getParameter("action"));
		System.out.println("==========================================");
		Sender.forward(request, response);
	}
}
