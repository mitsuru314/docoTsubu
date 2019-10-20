package test;

import model.Account;
import model.resisterLogic;
public class resisterLogicTest {
	
	public static void main(String[] args) {
		
		Account account1 = new Account("userId", "pass", "mail", "name", 10);
		Account account2 = new Account("mitsui", "19930216", "aaMAILAAA", "aADACHI", 236);
		createTest1(account1);
		createTest2(account2);
	}
	
	public static void createTest1(Account account){
		resisterLogic resisterLogic = new resisterLogic();
		boolean result = resisterLogic.execute(account);
		if(result) {
			System.out.println("成功しました");
		}else {
			System.out.println("失敗しました");
		}
	}
	
	public static void createTest2(Account account){
		resisterLogic resisterLogic = new resisterLogic();
		boolean result = resisterLogic.execute(account);
		if(result) {
			System.out.println("成功しました");
		}else {
			System.out.println("失敗しました");
		}
	}
	
}
