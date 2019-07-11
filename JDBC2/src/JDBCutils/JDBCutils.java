package JDBCutils;
/**
 * ������
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCutils {

	// ����һ�����ӳأ�����������ӳ�ֻ��Ҫ����һ�μ��ɡ�
	private static final ComboPooledDataSource DATA_SOURCE = new ComboPooledDataSource();

	//������ӵķ���
	public static Connection getConnection() throws SQLException {
		return DATA_SOURCE.getConnection();
	}
	// ������ӳ�:
	public static DataSource getDataSource() {
		return DATA_SOURCE;
	}
	//�ͷ���Դ�ķ���
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
		// ��Դ�ͷţ�
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
