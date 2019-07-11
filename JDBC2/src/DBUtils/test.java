package DBUtils;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import JDBCutils.JDBCutils;

public class test {
	@Test
	//Ôö
	public void demo1() throws SQLException{
		QueryRunner qr1 = new QueryRunner(JDBCutils.getDataSource());
	    qr1.update("insert into onssong values(?,?,?,?,?,?)",4,"aaa","bbb",50,50,"ok");
	}
	
	@Test
	//¸Ä
	public void demo2() throws SQLException{
		QueryRunner qr2 = new QueryRunner(JDBCutils.getDataSource());
		qr2.update("update onssong set song = ?,singer = ? where number = ?", "imjustme","forest",4);
	}
	
	@Test
	//É¾
	public void demo3() throws SQLException{
		QueryRunner qr3 = new QueryRunner(JDBCutils.getDataSource());
		qr3.update("delete from onssong where number = ?", 4);
	}
	
	
}
