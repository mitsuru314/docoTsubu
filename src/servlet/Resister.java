package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Account;
import model.resisterLogic;


@WebServlet("/Resister")
public class Resister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/resister.jsp");
		d.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//UTF-8をデコード
		request.setCharacterEncoding("UTF-8");
		//リクエストパラメータの取り出し
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		String mail = request.getParameter("mail");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		//アカウントインスタンスの生成
		Account account = new Account(userId, pass, mail, name, age);
		
		//アカウントの登録
		resisterLogic resisterLogic = new resisterLogic();
		boolean result = resisterLogic.execute(account);
		
		if (result) {
			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/resisterOK.jsp");
			d.forward(request, response);
		}else {
			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/resister.jsp");
			d.forward(request, response);
		}
	}

}
