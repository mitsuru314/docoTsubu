package docoTsubu;

public class PostMutterLogic {
	public void execute(Mutter mutter) {
		MutterDAO MutterDAO = new MutterDAO();
		MutterDAO.create(mutter);
	}
}
