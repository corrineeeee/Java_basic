package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.usermodel;
import domain.user;

/**
 * Servlet implementation class login
 */
public class login extends HttpServlet {
	
	
    public login() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		user user = new user();
		user.setUsername(username);
		user.setPassword(password);
		String checkcode1 = request.getParameter("checkcode");
		String checkcode2 = (String) request.getSession().getAttribute("checkcode");
		boolean flag = checkcode1.equalsIgnoreCase(checkcode2);
		if(flag == false){
			//验证码错误
			request.setAttribute("wrong", "failed");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		usermodel usermodel = new usermodel();
		user existuser;
		try {
			existuser = usermodel.login(user);
		if(existuser==null){
			//用户不存在
			request.setAttribute("wrong", "unexist");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			
		}else{
			//登陆成功
			HttpSession session = request.getSession();
			session.setAttribute("existuser", existuser);
			response.sendRedirect("/weblistener/success.jsp");
		} }catch (SQLException e) {
			e.printStackTrace();
		}
			
		}
		
	



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
