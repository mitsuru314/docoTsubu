package docoTsubu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MutterDAO {
	private final String JDBC_URL = "jdbc:postgresql://localhost:5432/dokotsubu";
	private final String DB_USER = "dokotsubu";
	private final String DB_PASS = "dokotsubu";
	
	public ArrayList<Mutter> findAll(){
		ArrayList<Mutter> mutterList = new ArrayList<Mutter>();
		Connection conn = null;
		try {
			//JDBCドライバ読み込み,データベースに接続
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			//SELECT文を準備
			String sql = "SELECT ID, NAME, TEXT FROM MUTTER ORDER BY ID DESC";
			//データベースへ命令を送信
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//データベースから検索結果を取得
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				String text = rs.getString("TEXT");
				Mutter Mutter = new Mutter(id, name, text);
				mutterList.add(Mutter);
			}

		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			return null;
		}
		finally {
			//データベースの切断
			if (conn != null) {
				try {
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
					return null;
				}
			}
		}
		return mutterList;
	}
	
	
	
	
	//データベースにデータを追加する
	public boolean create(Mutter mutter) {
		Connection conn = null;
		try {
			//JDBCドライバ読み込み,データベースに接続
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			//sql文の用意. IDについては自動連番となっているため書かなくてもよい
			String sql = "INSERT INTO mutter (NAME, TEXT) VALUES( ?, ? )";
			//データベースへ命令を送信
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//INSERT文の「?」に使用する値を設定しSQL文を完成
			pStmt.setString(1, mutter.getUserName());
			pStmt.setString(2, mutter.getText());
			
			//INSERT文を実行.成功かどうかを確認
			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			//データベースの切断
			if (conn != null) {
				try {
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
					return false;
				}
			}
		}
		return true;
	}
}
