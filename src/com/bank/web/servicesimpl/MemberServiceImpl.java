package com.bank.web.servicesimpl;

import com.bank.web.daoimpls.MemberDAOImpl;
import com.bank.web.daos.MemberDAO;
import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.EmployeeBean;
import com.bank.web.domains.MemberBean;
import com.bank.web.services.MemberService;
import java.util.ArrayList;
import java.util.List;
public class MemberServiceImpl implements MemberService {

	private List<CustomerBean> customers;
	private List<EmployeeBean> employees;
	
	MemberDAO dao;
	
	public MemberServiceImpl() {
		
		dao = new MemberDAOImpl();
		
	//	customers = new ArrayList<CustomerBean>();
	//	employees = new ArrayList<EmployeeBean>();
	//	DAO 연결하면 사용 안함	
		customers = new ArrayList<>();	// 생량 가능
		employees = new ArrayList<>();
	}
	@Override
	public void join(CustomerBean param) {
	//	customers.add(param);	
		dao.insertCustomer(param);
		
	}

	@Override
	public void register(EmployeeBean param) {
		employees.add(param);	
	}

	@Override
	public List<CustomerBean> findAllCustomers() {
		return customers;
	}

	@Override
	public List<EmployeeBean> findAllEmployees() {
		// TODO Auto-generated method stub
		return employees;
	}

	@Override
	public int countCustomers() {
		return customers.size();
	}

	@Override
	public int countEmployees() {
		return employees.size();
	}

	@Override
	public MemberBean findById(String id) {
		MemberBean m = new MemberBean();
		for(CustomerBean c : customers) {
			if(id.equals(c.getId())) {
				m = c;
				return m;
			}
		}
		for(EmployeeBean e : employees) {
			if(id.equals(e.getId())) {
				m = e;
				break;
			}
		}
		return m;
	}

	@Override
	public List<MemberBean> findByName(String name) {
		List<MemberBean> members = new ArrayList<MemberBean>();
		int count = 0;
		for(CustomerBean c : customers) {
			if(name.equals(c.getName())) {
				count++;
			}
		}
		for(EmployeeBean e : employees) {
			if(name.equals(e.getName())) {
				count++;
			}
		}
		return members;
	}

	@Override
	public CustomerBean login(MemberBean param) {

		CustomerBean cb = new CustomerBean();
		cb = dao.login(param);
		return cb;
	}

	@Override
	public boolean existId(String id) {
		MemberBean m = findById(id);
		return (employees.contains(m) || customers.contains(m));
	}

	@Override
	public void updatePass(MemberBean param) {
		String id = param.getId();
		String oidPw = param.getPw().split(",")[0];
		String newPw = param.getPw().split(",")[1];
	//	MemberBean m = findById(pa)
	}

	@Override
	public boolean deleteMember(MemberBean param) {

		MemberBean m = findById(param.getId());
		
		return (employees.contains(m)) 
				? employees.remove(m) 
				: customers.remove(m);

	}

	@Override
	public int getSameCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
