package DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.junit.Test;

import JDBCutils.JDBCutils;

public class querytest {
	@Test 
	public void demo1() throws SQLException{
		QueryRunner qr1 = new QueryRunner(JDBCutils.getDataSource());
		user user = qr1.query("select * from user where age = ?	", new ResultSetHandler<user>(){

			@Override
			public user handle(ResultSet rs) throws SQLException {
				user user = new user();
				if(rs.next()){
					user.setAge(rs.getInt("age"));
					user.setName(rs.getString("name"));
				}
				return user;
			}
			
		},21);
		System.out.println(user);
		
	}
}
