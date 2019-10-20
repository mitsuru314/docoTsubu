package TestDriver;

import java.util.ArrayList;
import docoTsubu.Mutter;
import docoTsubu.MutterDAO;

public class driverMutterDAO {
	public static void main(String[] args) {
		MutterDAO MutterDAO = new MutterDAO();
		ArrayList<Mutter> mutterList = MutterDAO.findAll();
		for(Mutter mutter: mutterList) {
			System.out.println("ID: " + mutter.getId() + " NAME: " + mutter.getUserName() + "TEXT: " + mutter.getText());
			
		}
	}
}
