package model;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import utils.JDBCUtils2;
import domain.user;

public class userModel {

	public user login(user user) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
		user userexist = queryRunner.query(
				"select * from test where username = ? and password = ?",
				new BeanHandler<user>(user.class), user.getName(),
				user.getPassword());
		return userexist;
	}

	

}
