package model;

import model.Account;
import DAO.AccountDAO;

public class resisterLogic {
	public boolean execute(Account account) {
		AccountDAO AccountDAO = new AccountDAO();
		
		boolean result;
		result = AccountDAO.create(account);
		if(result) {
			return true;
		}else {
			return false;
		}
	}
}
