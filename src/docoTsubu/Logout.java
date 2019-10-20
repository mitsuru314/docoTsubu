package docoTsubu;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//セッションの破棄
		HttpSession session = request.getSession();
		session.invalidate();
		
		//ログアウト画面へ移行
		RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/docoTsubu/logout.jsp");
		d.forward(request, response);
	}


}
