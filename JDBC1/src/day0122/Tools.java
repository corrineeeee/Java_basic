package day0122;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//jdbc������
//��Ϊ��ͳJDBC�Ŀ�����ע��������������ӣ�
//�ͷ���Դ��Щ���붼���ظ���д�ġ�
//���Կ��Խ��ظ��Ĵ�����ȡ��һ����������ɡ�
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
