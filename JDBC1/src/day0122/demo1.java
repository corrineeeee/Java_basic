package day0122;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class demo1 {
	@Test
	public void demo11() throws Exception {
		Connection conn = null;
		Statement sm = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/corrine", "root", "0616");
			sm = conn.createStatement();
			// 增
			String sqlsave = "insert into onssong values (4,'反正你也不会听','ubercracker','50','50','OK')";
			int num = sm.executeUpdate(sqlsave);
			if (num > 0) {
				System.out.println("success!");
			}
			// 改
			String sqlupdate = "update onssong set prices = '55' where number = 4";
			int num1 = sm.executeUpdate(sqlupdate);
			if (num1 > 0) {
				System.out.println("success!");
			}
			// 删
			String sqldelete = "delete from onssong where number = 4";
			int num2 = sm.executeUpdate(sqldelete);
			if (num2 > 0) {
				System.out.println("success!");
			}
			// 查
			String sql = "select *from onssong";
			rs = sm.executeQuery(sql);
				// 循环遍历输出
			while (rs.next()) {
				System.out.print(rs.getInt("number") + "-");
				System.out.print(rs.getString("song") + "-");
				System.out.print(rs.getString("singer") + "-");
				System.out.print(rs.getInt("prices") + "-");
				System.out.print(rs.getString("commands"));
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// rs.close();
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				rs = null;
			}
			// sm.close();
			if (sm != null) {
				try {
					sm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				sm = null;
			}
			// conn.close();
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

}
