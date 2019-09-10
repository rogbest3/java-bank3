package com.bank.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.web.pool.Constants;

import lombok.Data;
@Data
public class Command implements Order{
													// 의존관계
	protected HttpServletRequest request;			// A request(객체 request) is wrapped under an object as command
	protected String action, domain, page, view;	// 상속 관계에서는 protected 사용

	@Override
	public void execute() {
		setDomain();
		setPage();
	//	System.out.printf("리퀘스트가 가야할 길 : " + String.format(Constants.VIEW_PATH, domain, page) + "\n");
		this.view = String.format(Constants.VIEW_PATH, domain, page);
		System.out.println("4 - Command execute 실행");
	}
	public void setDomain() {
		String path = request.getServletPath();		//	/customer.do
	//	System.out.printf("서블릿 패스 ? : %s\n", path);
		domain = path.replace(".do", "");			//	.do 삭제
		domain = domain.substring(1);				//	/customer의 1번째부터 출력, 0번째의 /빼고 customer만 출력
		
	}
	public void setPage() {
		System.out.println("Command_setpage 전 : " + page);
		page = request.getParameter("page");
		System.out.println("Command_setpage 후 : " + page);
	}

}
