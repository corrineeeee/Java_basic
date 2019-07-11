package day0122;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//jdbc工具类
//因为传统JDBC的开发，注册驱动，获得连接，
//释放资源这些代码都是重复编写的。
//所以可以将重复的代码提取到一个类中来完成。
public class Tools {
	private static final String driverClassName;
	private static final String url;
	private static final String username;
	private static final String password;
	
	static{
		driverClassName = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://localhost:3306/onssong";
		username = "root";
		password = "0616";
	}
	
	public static void loadDriver(){
		try{
			Class.forName(driverClassName);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Connection getConn (){
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(url, username, password);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void release(Statement sm,Connection conn){
		if (sm != null) {
			try {
				sm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			sm = null;
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
	
	public static void release(ResultSet rs,Statement sm,Connection conn){
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if (sm != null) {
			try {
				sm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			sm = null;
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
}
