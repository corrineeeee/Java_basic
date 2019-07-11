package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;
import org.apache.commons.dbutils.QueryRunner;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import procity.area;
import procity.city;
import procity.province;
import utils.check;

public class procity extends HttpServlet {
	
	private Map<province, List<city>> map;
	
	@Override
	public void init() throws ServletException {
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String method = request.getParameter("method");
		if("province".equals(method)){
			try {
				List<province> province = check.check();
				String json= JSONObject.toJSONString(province);
				response.getWriter().write(json);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if("city".equals(method)){
			try {
				
				String province = request.getParameter("province");
				List<city> city = check.checkcity(province);
				String json= JSONObject.toJSONString(city);
				response.getWriter().write(json);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if("area".equals(method)){
			String province = request.getParameter("province");
			String city = request.getParameter("city");
			try {
				List<area> area = check.checkarea(province, city);
				String json = JSONObject.toJSONString(area);
				response.getWriter().write(json);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
