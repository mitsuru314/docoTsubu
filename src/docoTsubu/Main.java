package docoTsubu;

import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import docoTsubu.Mutter;
import docoTsubu.PostMutterLogic;
import docoTsubu.GetMutterListLogic;
import model.Login;


@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//データベースからつぶやきリストの呼び出し
		GetMutterListLogic GetMutterListLogic = new GetMutterListLogic();
		ArrayList<Mutter> mutterList = GetMutterListLogic.execute();
		request.setAttribute("mutterList", mutterList);
		
		//ログインしているかをセッションスコープ内のユーザインスタンスで確認
		HttpSession session = request.getSession();
		Login login = (Login) session.getAttribute("login");
		
		if(login == null) {//ログインしていない場合
			response.sendRedirect("/docoTsubu2/");
		}else {//ログインしている場合メイン画面へフォワードを投げる
			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/docoTsubu/main.jsp");
			d.forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエスト情報をエンコード
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("mutter");
		if(text != null && text.length()!=0) {//つぶやきがnullでないかを確認

			//セッションスコープに保存されたユーザ情報を取得
			HttpSession session = request.getSession();
			Login login = (Login) session.getAttribute("login");
			
			//つぶやきをつぶやきリストに追加
			Mutter mutter = new Mutter(login.getUserId(), text);
			PostMutterLogic PostMutterLogic = new PostMutterLogic();
			PostMutterLogic.execute(mutter);
			
			//データベースからつぶやきリストの呼び出し
			GetMutterListLogic GetMutterListLogic = new GetMutterListLogic();
			ArrayList<Mutter> mutterList = GetMutterListLogic.execute();	
			
			//つぶやきリストをリクエストスコープへ保存
			request.setAttribute("mutterList", mutterList);
			//メイン画面でつぶやきリストを表示
			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/docoTsubu/main.jsp");
			d.forward(request, response);
		}else {
			String errorMessage = "つぶやきが投降されていません";
			request.setAttribute("errorMessage", errorMessage);
			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/docoTsubu/main.jsp");
			d.forward(request, response);
		}

	}
}