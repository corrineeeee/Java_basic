package model;

import java.sql.SQLException;

import domain.user;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class usermodel {



	public user login(user user) throws SQLException {
		QueryRunner queryRunner = new QueryRunner();
		user existuser = queryRunner.query("select * from test where username = ? and password = ?", new BeanHandler<user>(user.class),user.getUsername(),user.getPassword()
				
		);
		return existuser;
	}
}
