package com.bank.web.services;
import com.bank.web.domains.*;
import java.util.List;
public interface MemberService {
	public void join(CustomerBean param);		// create
	public void register(EmployeeBean param);

	public List<CustomerBean> findAllCustomers();
	public List<EmployeeBean> findAllEmployees();
	public int countCustomers();
	public int countEmployees();
	
	public MemberBean findById(String id);
	public List<MemberBean> findByName(String name);
	public CustomerBean login(MemberBean param);
	public boolean existId(String id);
	
	public void updatePass(MemberBean param);	// update
	public boolean deleteMember(MemberBean param);
	
	public int getSameCount();
}
