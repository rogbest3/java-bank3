package com.bank.web.daos;

import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.EmployeeBean;
import com.bank.web.domains.MemberBean;

public interface MemberDAO {
	public void insertCustomer(CustomerBean param);
	
	public void insertEmployee(EmployeeBean param);
	
	public CustomerBean login(MemberBean param);
	
}
