package model;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import student.student;
import utils.JDBCUtils;

public class studentModel {

	public List<student> getImformation() throws SQLException {
		
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		List<student> list = runner.query("select *from student", new BeanListHandler<student>(student.class));
		return list;
	}

}
