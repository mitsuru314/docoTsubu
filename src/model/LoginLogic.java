package model;
import DAO.AccountDAO;

public class LoginLogic {
	public boolean execute(Login login) {
		AccountDAO AccountDAO = new AccountDAO();
		Account account = AccountDAO.findByLogin(login);
		return account != null;
	}
}
