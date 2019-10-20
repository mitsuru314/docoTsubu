package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Account;
import model.Login;

public class AccountDAO {

	private final String DRIVER_NAME = "org.postgresql.Driver";
	private final String JDBC_URL = "jdbc:postgresql://localhost:5432/dokotsubu";
	private final String DB_USER = "dokotsubu";
	private final String DB_PASS = "dokotsubu";

	public Account findByLogin(Login login) {
		Account account = null;
		Connection conn = null;
		try {
			//JDBCドライバ読み込み,データベースに接続
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			//SELECT文を準備
			String sql = "SELECT * FROM ACCOUNT WHERE USER_ID = ? AND PASS = ?";
			//データベースへ命令を送信
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login.getUserId());
			pStmt.setString(2, login.getPass());

			//データベースから検索結果を取得
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				String userId = rs.getString("USER_ID");
				String name = rs.getString("NAME");
				String pass = rs.getString("PASS");
				String mail = rs.getString("MAIL");
				int age = rs.getInt("AGE");
				
				account = new Account(userId, pass, mail, name, age);
				
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
		//ユーザが見つかった場合は返す
		return account;
	}
	
	public boolean create(Account account) {
		Connection conn = null;
		try {
			//JDBCドライバ読み込み,データベースに接続
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			//SELECT文を準備
			String sql = "INSERT INTO ACCOUNT(USER_ID, PASS, MAIL, NAME, AGE) VALUES(?, ?, ?, ?, ?)";
			//データベースへ命令を送信
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, account.getUserId());
			pStmt.setString(2, account.getPass());
			pStmt.setString(3, account.getMail());
			pStmt.setString(4, account.getName());
			pStmt.setInt(5, account.getAge());

			//データベースから検索結果を取得
			int result = pStmt.executeUpdate();
			if(result !=1) {
				return false;
			}
	
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			return false;
		}
		finally {
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
		//インサート出来たらtrueを返す
		return true;
	}
}
