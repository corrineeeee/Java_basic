package dataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;



//测试自定义连接池
public class test {
	@Test
	public void demo1 (){
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		myDataSource ds = null;
		try{
			ds = new myDataSource();
			conn = ds.getConnection();
			String sql = "select * from onssong";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt("number"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			Tools.release(rs, ps);
			ds.backback(conn);
		}
	}
}
