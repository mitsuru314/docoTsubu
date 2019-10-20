package test;
import DAO.AccountDAO;
import model.Login;
import model.Account;
public class AccountDAOTest {
	
	public static void main(String[] args) {
		testFindByLogin1(); //成功の場合
		testFindByLogin2(); //失敗の場合
	}
	
	public static void testFindByLogin1() {
		
		AccountDAO AccountDAO = new AccountDAO();
		Login login = new Login("mitsuru", "0216");
		Account account = new Account();
		account = AccountDAO.findByLogin(login);
		
		if (account != null) {
			System.out.println("成功");
		}else {
			System.out.println("失敗");
		}
	}
	
	public static void testFindByLogin2() {
		
		AccountDAO AccountDAO = new AccountDAO();
		Login login = new Login("mitsuru", "0217");
		Account account = new Account();
		account = AccountDAO.findByLogin(login);
		
		if (account != null) {
			System.out.println("成功");
		}else {
			System.out.println("失敗");
		}
	}

}
