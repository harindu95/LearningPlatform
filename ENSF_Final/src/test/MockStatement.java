package test;

import static org.junit.Assert.assertEquals;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.MySQLConnection;
import com.mysql.jdbc.PreparedStatement;

public class MockStatement extends PreparedStatement {

	String expected;
	public MockStatement(MySQLConnection conn, String catalog,String sql) throws SQLException {
		super(conn, catalog);
		this.expected = sql;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public ResultSet executeQuery(String sql) {
		
		assertEquals(this.expected + " is expected", expected, sql);
		return null;
	}
	

}
