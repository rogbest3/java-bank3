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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 역직렬화
		System.out.println("맥락이 맞아서 여기 도착");    
	//	RequestDispatcher rd = null;
		// 데이터 저장이 안됨.
	//	

		MemberBean mparam = new MemberBean();
		CustomerBean param = new CustomerBean();	//	같은 메소드 안에 있기 때문에 null 넣어서 나눌 필요없지만 메소드 밖에 놓게 되면 null을 주고 각 메소드에서 초기와 해줘야함.
		MemberService service = new MemberServiceImpl();

		
		Receiver.init(request);
		Receiver.cmd.execute();
		if(Receiver.cmd.getAction()==null) {
			Receiver.cmd.setPage();
		}
		
		switch (Receiver.cmd.getAction()) {	//	move 가 default 됨
		case "join" : 
			System.out.println("join 진입");
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String ssn = request.getParameter("ssn");
			String credit = request.getParameter("credit");
			
			param.setCredit(credit);
			param.setId(id);
			param.setName(name);
			param.setPw(pw);
			param.setSsn(ssn);
			System.out.println("회원정보 : "+ param.toString());
			service.join(param);
			Receiver.cmd.setPage("login");
			break;
			
		case "login":		
			id = request.getParameter("id");
			pw = request.getParameter("pw");
			System.out.printf("로그인 서비스 진입 후 아이디 : %s, 비번 : %s\n", id, pw);
			
			mparam.setId(id);
			mparam.setPw(pw);
		//	param = service.login(mparam);
			CustomerBean cust = service.login(mparam);
			System.out.printf("login : %s, %s\n", cust.getId(), cust.getPw());
		
		//	if(cust == null) {
			if(id == cust.getId() ) {
				System.out.println("로그인 성공");
				request.setAttribute("customer", cust);	// request에 객체 param(요소가 됨)을  customer라는 이름으로 담음, jsp에서 출력s
				Receiver.cmd.setPage("mypage");
			}else {
				System.out.println("로그인 실패");
				Receiver.cmd.setPage("login");
			}

			break;
		case "mypage" :
			
			break;
			
		case "existId" :
			
			break;	
		}
		
		Sender.forward(request, response);
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
