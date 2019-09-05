package com.bank.web.domains;

public class EmployeeBean extends MemberBean{

	private static final long serialVersionUID = 1L;
	private String sabun;
	
	public void setSabun(String sabun) {
		this.sabun = sabun;
	}
	public String getSabun() {
		return sabun;
	}
	@Override
	public String toString() {
		return "직원정보 [아이디=" + getId() 
				+ ", 비번=" + getPw()
				+ ", 이름=" + getName()
				+ ", 주민번호=" + getSsn()
				+ ", 사번=" + sabun
				+ "]";
				
	}
	
}
