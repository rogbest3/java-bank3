package com.bank.web.domains;

public class CustomerBean extends MemberBean {

	private static final long serialVersionUID = 1L;
	private String credit;

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	@Override
	public String toString() {
		return "고객정보 [아이디=" + getId() 
				+ ", 비번=" + getPw() 
				+ ", 이름=" + getName() 
				+ ", 주민번호=" + getSsn()
				+ ", 신용등급=" + credit
				+ "]";
		
	}
	
}
