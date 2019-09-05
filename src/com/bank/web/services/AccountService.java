package com.bank.web.services;
import com.bank.web.domains.AccountBean;
import java.util.List;
public interface AccountService {
	public void createAccount(int money);
	public String createAccountNum();
	public String findDate();
	
	public int countAccounts();
	public List<AccountBean> findAll();
	public AccountBean findByAccountNum(String accountNum);
	public boolean existAccountNum(String accountNum);

	public void depositMoney(AccountBean param);
	public void withdrawMoney(AccountBean param);
	public void deleteAccountNum(String accountNum);
}
