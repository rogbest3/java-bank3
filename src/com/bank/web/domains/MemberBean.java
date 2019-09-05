package com.bank.web.domains;

import java.io.Serializable;

public class MemberBean implements Serializable{

		private static final long serialVersionUID = 1L;
	
		private String id, pw, name, ssn;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getPw() {
			return pw;
		}

		public void setPw(String pw) {
			this.pw = pw;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSsn() {
			return ssn;
		}

		public void setSsn(String ssn) {
			this.ssn = ssn;
		}

		@Override
		public String toString() {
			return "회원정보 [아이디=" + id 
					+ ", 비번=" + pw 
					+ ", 이름=" + name 
					+ ", 주민번호=" + ssn 
					+ "]";
		}
		
}
