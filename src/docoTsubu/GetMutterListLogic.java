package docoTsubu;

import java.util.ArrayList;

import docoTsubu.MutterDAO;


public class GetMutterListLogic {
	public ArrayList<Mutter> execute(){
		MutterDAO MutterDAO = new MutterDAO();
		return MutterDAO.findAll();
		
	}
}
