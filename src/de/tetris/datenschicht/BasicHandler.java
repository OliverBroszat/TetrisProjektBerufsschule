package de.tetris.datenschicht;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class BasicHandler {
	protected static Connection conn;
	
	protected ResultSet createExecuteStatement(String statement){
		Statement sql = null;
		ResultSet data = null;
		
		try {
			sql =  conn.createStatement();
			data = sql.executeQuery(statement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	public int createUpdateStatement(String statement) {
		Statement sql = null;
		int status = 0;
		
		try {
			sql =  conn.createStatement();
			status = sql.executeUpdate(statement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
}
