package com.bank.web.command;

import javax.servlet.http.HttpServletRequest;

import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.MemberBean;
import com.bank.web.services.MemberService;
import com.bank.web.servicesimpl.MemberServiceImpl;
public class LoginCommand extends MoveCommand{
	
	public LoginCommand(HttpServletRequest request) throws Exception {
		super(request);	//	상위 생성자 호출 - MoveCommand(request)
		System.out.println("7 - loginCommand");
	}
	@Override
	public void execute() {
		System.out.println("2 - LoginCommand_execute 실행");
		super.execute();
		System.out.println("6 -LoginCommand_execute_super.execute() 실행");
		CustomerBean param = new CustomerBean();
		MemberService service = new MemberServiceImpl();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		System.out.printf("로그인 서비스 진입 후 아이디 : %s, 비번 : %s\n", id, pw);
		
		param.setId(id);
		param.setPw(pw);

		CustomerBean cust = service.login(param);
		System.out.println("login : " + cust);
		String page = "";
		if(cust == null) {
			System.out.println("로그인 실패");
			page = "login";
		}else {
			System.out.println("로그인 성공");		
			page = "mypage";
		}
		System.out.println("login_page : " + page);
		System.out.println("LC_Receiver.cmd.setPage(page) 전 : " + request.getParameter("page"));
		Receiver.cmd.setPage(page);
		request.setAttribute("customer", cust);	// request에 객체 param(요소가 됨)을  customer라는 이름으로 담음, jsp에서 출력s

		System.out.println("LC_Receiver.cmd.setPage(page) 후 : " + request.getParameter("page"));
		
	}
	
}
