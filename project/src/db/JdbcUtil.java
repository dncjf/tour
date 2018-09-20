package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtil {
	static {
		/*try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	public static Connection getConnection() {
		Connection con = null;
		/*try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "java", "java");
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}*/
		try {
			Context ctx = new InitialContext();
			//tomcat 자체의 Context를 얻어옴
			//javax.naming.Context, javax.naming.In...
	DataSource dataFactory = 
	(DataSource)ctx.lookup("java:comp/env/jdbc/jsptest");
	//java:comp/env/ : 리소스 정의 컨텍스트를 얻어오는 JNDI
			con = dataFactory.getConnection();
			//javax.sql.DataSource
			
			con.setAutoCommit(false);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
	}
	
	public static void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void close(Statement stmt) {
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//==transaction 메소드 ----
	public static void commit(Connection con) {
		try {
			con.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void rollback(Connection con) {
		try {
			con.rollback();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}














