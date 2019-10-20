package docoTsubu;
import java.io.Serializable;
public class Mutter implements Serializable{
	
	private String userName;
	private String text;
	private int id;
	
	public Mutter() {}
	public Mutter(int id, String userName, String text) {
		this.id = id;
		this.userName = userName;
		this.text = text;
	}
	public Mutter(String userName, String text) {
		this.userName = userName;
		this.text = text;
	}
	
	
	public String getUserName() {
		return userName;
	}
	public String getText() {
		return text;
	}
	public int getId() {
		return id;
	}

}
