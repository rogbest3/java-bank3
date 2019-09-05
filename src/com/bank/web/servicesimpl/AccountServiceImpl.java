package com.bank.web.servicesimpl;

import com.bank.web.domains.AccountBean;
import com.bank.web.services.AccountService;
import java.util.Date;
import java.util.Random;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.ArrayList;;
public class AccountServiceImpl implements AccountService {

	private List <AccountBean> accounts;
	
	public AccountServiceImpl() {
		accounts = new ArrayList<>();
	}
	
	@Override
	public void createAccount(int money) {
		AccountBean a = new AccountBean();
		a.setMoney(money);
		a.setAccountNum(createAccountNum());
		a.setToday(findDate());
		accounts.add(a);
	}

	@Override
	public String createAccountNum() {
		Random random = new Random();
		return String.format("%d-%04d", 
								random.nextInt(9999) + 1000, 
								random.nextInt(9999) + 1 );
	}

	@Override
	public String findDate() {	
		return new SimpleDateFormat("yyyy-MM-dd hh:mm").format(new Date());
	}

	@Override
	public int countAccounts() {
		return accounts.size();
	}

	@Override
	public List<AccountBean> findAll() {
		return accounts;
	}

	@Override
	public AccountBean findByAccountNum(String accountNum) {
		AccountBean aResult = new AccountBean();
		for(AccountBean a : accounts ) {
			if(accountNum.equals(a.getAccountNum())) {
				aResult = a;
				break;		
			}
		}
		return aResult;
	}

	@Override
	public boolean existAccountNum(String accountNum) {
		return accounts.contains(findByAccountNum(accountNum));
	}

	@Override
	public void depositMoney(AccountBean param) {
		int idx = accounts.indexOf(param);
		accounts.get(idx).setMoney(accounts.get(idx).getMoney() + param.getMoney());
	}

	@Override
	public void withdrawMoney(AccountBean param) {
		int idx = accounts.indexOf(param);
		int bankMoney = accounts.get(idx).getMoney();
		int InputMoney = param.getMoney();
		if(InputMoney <= bankMoney) {
			accounts.get(idx).setMoney(bankMoney - InputMoney);
		}
	}

	@Override
	public void deleteAccountNum(String accountNum) {
		AccountBean a  = findByAccountNum(accountNum);
		accounts.remove(a);
	}

}
