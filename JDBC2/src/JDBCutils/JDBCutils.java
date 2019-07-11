package JDBCutils;
/**
 * 工具类
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCutils {

	// 创建一个连接池：但是这个连接池只需要创建一次即可。
	private static final ComboPooledDataSource DATA_SOURCE = new ComboPooledDataSource();

	//获得连接的方法
	public static Connection getConnection() throws SQLException {
		return DATA_SOURCE.getConnection();
	}
	// 获得连接池:
	public static DataSource getDataSource() {
		return DATA_SOURCE;
	}
	//释放资源的方法
	public static void release(Statement stmt, Connection conn) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			stmt = null;
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

	public static void release(ResultSet rs, Statement stmt, Connection conn) {
		// 资源释放：
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			rs = null;
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			stmt = null;
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
