package test;
import model.Login;
import model.LoginLogic;

public class testLoginLogic {
	public static void main(String[] args) {
		testLoginLogic1();
		testLoginLogic2();
	}
	
	public static void testLoginLogic1() {
		
		Login login = new Login("mitsuru", "0216");
		LoginLogic bo = new LoginLogic();
		if(bo.execute(login)) {
			System.out.println("成功しました");
		}else {
			System.out.println("失敗しました");
		}
		
	}
	
	public static void testLoginLogic2() {
		Login login = new Login("mitsuru", "0217");
		LoginLogic bo = new LoginLogic();
		if(bo.execute(login)) {
			System.out.println("成功しました");
		}else {
			System.out.println("失敗しました");
		}
	}
}
