package servlet;

import java.io.IOException;

import dto.UserDto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import logic.LoginLogic;
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String error = "";
		UserDto user = null;
		if(id.isBlank() || pass.isBlank()) {
			error = "未入力です";
		}else{
			LoginLogic loginlogic = new LoginLogic();
			user = loginlogic.execute(id, pass);
			if(user == null){
				error = "不正なID・パスワードです";
			}
		}
		
		if(error.equals("")) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect("top");
		}else{
			request.setAttribute("error", error);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
		}
		
	}
}
