package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import dao.pagebean;
import domain.china;
import service.service;

public class page extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		service service = new service();
		page page = new page();
		int pageno = Integer.parseInt(request.getParameter("pageno")) ;
		int pagesize = Integer.parseInt(request.getParameter("pagesize")) ;
		
		try {
			pagebean<china> list = service.getdata(pageno, pagesize);
			String json = JSONObject.toJSONString(list);
			response.getWriter().write(json);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
