package com.bank.web.command;

import javax.servlet.http.HttpServletRequest;

public class MoveCommand extends Command{
	
	// 생성자
	public MoveCommand(HttpServletRequest request) throws Exception {
		setRequest(request);
		setDomain(domain);
		String t = "";
	//	if(request.getParameter("action").equals("")) {
	//		t = "move";
	//	}
	//	setAction(t);
		setAction((request.getParameter("action")==null)	//	action = move를 default로 처리 => 단순이동(location)이 form 태그 이동(data 이동)보다 많기 때문
						? "move":request
						.getParameter("action"));
		execute();
	}
	public void execute() {
		super.execute();
		request.setAttribute("page", request.getParameter("page"));
	}
}
