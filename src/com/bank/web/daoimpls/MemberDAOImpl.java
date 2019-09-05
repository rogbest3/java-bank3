package com.bank.web.daoimpls;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import com.bank.web.daos.MemberDAO;
import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.EmployeeBean;
import com.bank.web.domains.MemberBean;
import com.bank.web.pool.Constants;;
public class MemberDAOImpl implements MemberDAO{
	

	@Override
	public void insertCustomer(CustomerBean param) {
		try {
			File file = new File(Constants.FILE_PATH + "customers0906.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
			writer.write(String.format("%s,%s,%s,%s,%s", 
										param.getId(), param.getPw(), param.getName(), param.getSsn(), param.getCredit() ));
			writer.newLine();
			writer.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void insertEmployee(EmployeeBean param) {
		try {
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public CustomerBean login(MemberBean param) {
		CustomerBean bean = new CustomerBean();
		String string = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Constants.FILE_PATH+"customers0906.txt"));
		//	while((string = reader.readLine()) != null){	
			string = reader.readLine();
			String[] arr = string.split(",");
			System.out.printf("아이디 : %s, 비번 : %s", arr[0], arr[1]);
				bean.setId(arr[0]);
				bean.setPw(arr[1]);
				bean.setName(arr[2]);
				bean.setSsn(arr[3]);
				bean.setCredit(arr[4]);
				if(arr[0].equals(param.getId())) {
					System.out.println("아이디 동일");
				}else {
					System.out.println("아이디 틀림");
				}
			
		//	}
			reader.close();	
			
			System.out.println("bean:"+bean.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return bean;
	}
	
	
}
