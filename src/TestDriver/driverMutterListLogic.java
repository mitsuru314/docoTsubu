package TestDriver;
import java.util.ArrayList;
import docoTsubu.Mutter;
import docoTsubu.GetMutterListLogic;

public class driverMutterListLogic {
	public static void main(String[] args) {

		GetMutterListLogic GetMutterListLogic = new GetMutterListLogic();
		
		ArrayList<Mutter> mutterList = GetMutterListLogic.execute();
		
		for(Mutter mutter: mutterList) {
			System.out.println("ID: " + mutter.getId() + " NAME: " + mutter.getUserName() + "TEXT: " + mutter.getText());
			
		}
	}
	
}
