package utils;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import procity.area;
import procity.city;
import procity.province;

public class check {
	 public static List<province> check() throws SQLException{
		 QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
		 List<province> province = queryRunner.query("select *from province ", new BeanListHandler<province>(province.class));
		return province;
	 }
	 
	 public static List<city> checkcity(String province) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
		List<city> city = queryRunner.query("select *from city c,province p where c.father=p.provinceID and p.province=?", new BeanListHandler<city>(city.class),province);
		return city;
	 }
	 
	 public static List<area> checkarea(String province,String city) throws SQLException{
			QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
			List<area> area= queryRunner.query("select areaID,area from city c,province p,area a where c.father=p.provinceID and a.father = c.cityID and p.province=? and c.city=?", new BeanListHandler<area>(area.class),province,city);
			return area;
		 }
	 
}
