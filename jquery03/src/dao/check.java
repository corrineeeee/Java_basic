package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import domain.china;
import utils.JDBCUtils2;

public class check {
	public static List<china> findall(int pageno, int pagesize)
			throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
		List<china> province = queryRunner.query(
				"select *from province limit ?,?", new BeanListHandler<china>(
						china.class), (pageno - 1) * pagesize, pagesize);
		return province;
	}
	public static int findallline() throws SQLException{
		QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
		Long query = (Long) queryRunner.query("select count(*)from province", new ScalarHandler());
		int intValue = query.intValue();
		return intValue;
		
	}
}
