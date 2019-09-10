package com.bank.web.command;

import javax.servlet.http.HttpServletRequest;

import com.bank.web.enums.Action;

//public class Commander extends MoveCommand{	// is-a관계(상속관계) - Commander is a MoveCommand (X)
public class Commander{
						
	public static Command order(HttpServletRequest request) {	// has-a관계(포함관계) - Commander has a Command (O) 
		Command cmd = new Command();							//	static은 단 하나 
//		cmd = new MoveCommand(request);	//	다형성
						
		String action = "";
		if(request.getParameter("action")==null) {
			action = "MOVE";
		}else {
			action = Action.valueOf(
					request.getParameter("action")
					.toUpperCase()).toString();
			System.out.println("액션 : " + action);
		}
		System.out.println("0 - action : " + action);
		System.out.println("0 - cmd.getPage() : " + cmd.getPage());
		try {
			switch (Action.valueOf(action)) {	// toUpperCase - 소문자로 담은 문자를 대문자로 변환
			case LOGIN :							
				System.out.println("스위치 LOGIN 동작");
				System.out.println("cmd.getPage() : " + cmd.getPage());
				cmd = new LoginCommand(request);	// 오버라이딩
				break;
	
			case JOIN :				
				System.out.println("스위치 JOIN 동작");
				cmd = new CreateCommand(request);
				break;
			case LIST :
				cmd = new ListCommand(request);
				break;
			case MOVE : 
				System.out.println("스위치 MOVE 동작");
				cmd = new MoveCommand(request);		
				break;
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("커맨더 동작 완료");
		return cmd;
	}
	

}
