package TestDriver;
import java.util.ArrayList;
import docoTsubu.Mutter;
import docoTsubu.MutterDAO;

public class driverMutterDAOCreate {
	public static void main(String[] args) {
		MutterDAO MutterDAO = new MutterDAO();
		Mutter mutter = new Mutter("AdachiMitsuruaa", "aaaaaaaaaaaaa");
		MutterDAO.create(mutter);

	}
}
