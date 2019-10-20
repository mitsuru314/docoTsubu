package test;
import model.Account;
import DAO.AccountDAO;

public class AccountDAOcreateTest {
	
	public static void main(String[] args) {
		Account account1 = new Account("userId", "pass", "mail", "name", 10);
		Account account2 = new Account("mitsuru", "0216", "MAILAAA", "ADACHI", 26);
		createTest1(account1);
		createTest2(account2);
	}
	
	public static void createTest1(Account account) {
		AccountDAO AccountDAO = new AccountDAO();
		
		boolean result = AccountDAO.create(account);
		
		if(result) {
			System.out.println("成功しました");
		}else {
			System.out.println("失敗しました");
		}
		
	}
	
	public static void createTest2(Account account) {
		AccountDAO AccountDAO = new AccountDAO();
		
		boolean result = AccountDAO.create(account);
		
		if(result) {
			System.out.println("成功しました");
		}else {
			System.out.println("失敗しました");
		}
		
	}
}
