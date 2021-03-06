package controller;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.websocket.Session;

import model.userModel;
import domain.user;


public class login extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码类型
		request.setCharacterEncoding("UTF-8");
		//接收表单收到的数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//新建一个对象存放数据
		user user = new user();
		user.setUsername(username);
		user.setPassword(password);
		String checkCode1 = request.getParameter("checkCode");
		String checkCode2 = (String) request.getSession().getAttribute("checkCode");
		request.getSession().removeAttribute("checkCode");
		Boolean flag = checkCode1.equalsIgnoreCase(checkCode2);
		if(flag == false){
			request.setAttribute("checkCodewrong", "checkCode Wrong!");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		//处理数据:
		userModel userModel = new userModel();
		try {
			user existuser = userModel.login(user);
			if(existuser == null){
				//数据不存在 登录错误 跳转回原来的界面并且输出信息
				request.setAttribute("wrong", "failed!");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}else{
				//登陆成功 跳转至成功界面
				HttpSession session = request.getSession();
				session.setAttribute("existuser", existuser);
				
				String remember = request.getParameter("ifremember");
				System.out.println(remember);
				if("true".equals(remember)){
					System.out.println("existuser.getName()---"+existuser.getUsername());
					Cookie cookie = new Cookie("ifremember",existuser.getUsername());
					System.out.println(cookie.getValue());
					cookie.setPath("/weblogin1");
					cookie.setMaxAge(60*60);
					response.addCookie(cookie);
				}
				response.sendRedirect("/weblogin1/success.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	}

}
