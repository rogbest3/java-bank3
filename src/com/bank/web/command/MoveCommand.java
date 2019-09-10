package com.bank.web.command;

import javax.servlet.http.HttpServletRequest;

public class MoveCommand extends Command{
	
	// 생성자
	public MoveCommand(HttpServletRequest request) throws Exception {
		setRequest(request);
		setDomain(domain);
	//	setPage(page);
		String t = "";
	//	if(request.getParameter("action").equals("")) {
	//		t = "move";
	//	}
	//	setAction(t);
		setAction((request.getParameter("action")==null)	//	action = move를 default로 처리 => 단순이동(location)이 form 태그 이동(data 이동)보다 많기 때문
						? "move":request
						.getParameter("action"));
		System.out.println("1 - MoveCommand 실행");
	//	execute();	
					/** ==> loginCommand execute() 실행
					 	action이 MOVE면 아래 execute() 실행하고
						action이 LOGIN이면 LoginCommand execute() 실행
					*/	
	}
	public void execute() {
		System.out.println("3 - Movecommand execute 실행");
		super.execute();
		System.out.println("5 - super.execute()(command) 실행 후");
		request.setAttribute("page", request.getParameter("page"));
	}

}
