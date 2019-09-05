package com.bank.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.MemberBean;
import com.bank.web.pool.Constants;
import com.bank.web.services.MemberService;
import com.bank.web.servicesimpl.MemberServiceImpl;

@WebServlet("/member.do")
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

		String jspName = "";
		MemberBean mparam = new MemberBean();
		CustomerBean param = new CustomerBean();	//	같은 메소드 안에 있기 때문에 null 넣어서 나눌 필요없지만 메소드 밖에 놓게 되면 null을 주고 각 메소드에서 초기와 해줘야함.
		MemberService service = new MemberServiceImpl();

		switch (request.getParameter("action")) {
		case "move":
			request.getRequestDispatcher(
					String.format(Constants.VIEW_PATH, "customer",
					request.getParameter("dest")))
					.forward(request, response);
			System.out.println("join 이동");
			break;
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
			request.getRequestDispatcher(
					String.format(Constants.VIEW_PATH, "customer",
					request.getParameter("dest")))
					.forward(request, response);
			
			break;
			
		case "login":		
			id = request.getParameter("id");
			pw = request.getParameter("pw");
			System.out.printf("로그인 서비스 진입 후 아이디 : %s, 비번 : %s\n", id, pw);
			
			mparam.setId(id);
			mparam.setPw(pw);
			param = service.login(mparam);
			System.out.println("---------++++++++++++++--------");
			System.out.println(param.toString());
			System.out.printf("param.getId : %s, param.getPw : %s\n", param.getId(), param.getPw());
			
			if(id.equals(param.getId())) {
				System.out.println("아이디 동일");
			}else {
				System.out.println("아이디 틀림");
			}
			
			if(id.equals(param.getId()) && pw.equals(param.getPw())) {
				System.out.println("로그인 성공");
				request.setAttribute("customer", param);	// request에 객체 param(요소가 됨)을  customer라는 이름으로 담음, jsp에서 출력s
				request.getRequestDispatcher(
						String.format(Constants.VIEW_PATH, "customer",
						request.getParameter("dest")))
						.forward(request, response);
			}else {
				System.out.println("로그인 실패");
				request.getRequestDispatcher(
						String.format(Constants.VIEW_PATH, "customer",
						"login"))
						.forward(request, response);
			}

			break;
		case "mypage" :
			
			break;
			
		case "existId" :
			
			break;
		}

	//	RequestDispatcher rd = request.getRequestDispatcher(String.format("WEB-INF/views/customer/%s.jsp", jspName));
	//	rd.forward(request, response);
		
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
