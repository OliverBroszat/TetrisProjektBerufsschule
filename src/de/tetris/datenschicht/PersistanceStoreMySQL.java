package de.tetris.datenschicht;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.mysql.jdbc.PreparedStatement;

import de.tetris.steuerungsschicht.Controller;


public class PersistanceStoreMySQL extends PersistanceStore{
	private Controller controller;
	
	private BestenlisteHandler bestenlisteHandler;
	private UserHander userHandler;
	private Connection connection;

	private String hostaddress;
	private String port = "3306";
	private String database;
	private String username = "root";
	private Statement stmt;
	
	public BestenlisteHandler getBestenlisteHandler() {
		return bestenlisteHandler;
	}


	public void setBestenlisteHandler(BestenlisteHandler bestenlisteHandler) {
		this.bestenlisteHandler = bestenlisteHandler;
	}


	public UserHander getUserHandler() {
		return userHandler;
	}


	public void setUserHandler(UserHander userHandler) {
		this.userHandler = userHandler;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getHostaddress() {
		return hostaddress;
	}


	public void setHostaddress(String hostaddress) {
		this.hostaddress = hostaddress;
	}


	public String getPort() {
		return port;
	}


	public void setPort(String port) {
		this.port = port;
	}


	public String getDatabase() {
		return database;
	}


	public void setDatabase(String database) {
		this.database = database;
	}
	
	public PersistanceStoreMySQL() {
			this.connection = null;
			super.connectionStatus = false;
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				System.out.println("INFO: Driver set");
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void setInfo(String hostaddress,String port, String database){ 
	     this.hostaddress = hostaddress;
	     this.port = port;
	     this.database = database;
	}
	
	public void setInfo(String hostaddress ,String port){
		 System.out.println("INFO: Settings set");
	     this.hostaddress = hostaddress;
	     this.port = port;
	}
	
	@Override
	public boolean createConnection(String database) {
		
		try {
			this.connection = DriverManager.
			            getConnection("jdbc:mysql://" + this.hostaddress + ":" + this.port + "/" + database
                                , this.username, "");
			this.connectionStatus = true;
			System.out.println("INFO: Database connection etablished");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this.connectionStatus;
	}
	
	public void test(){
		try {
			String stmt = "SELECT Nickname FROM tetrisuser";
			String stmt2 = "SELECT * FROM tetrisuser";
			String stmt4 = "SELECT * FROm tetrisuser WHERE Nickname = 'Zeyos'";
			
			String stmt3 = "SELECT (p.punkte * s.faktor) AS 'Highscores' " +
			", u.nickname, s.schwierigkeit " +
			"FROM tetrisuser u " +
			"JOIN punktestaende p " +
			"ON u.userID = p.userID " +
			"JOIN schwierigkeitsgrad s " +
			"ON p.schwierigkeit = s.schwierigkeit " +
			"ORDER BY (p.punkte * s.faktor) DESC";
			
			Statement sql = this.connection.createStatement();
			ResultSet results = sql.executeQuery(stmt4);
			evaluateStatement(results);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	private ArrayList<ArrayList<String>> evaluateStatement(ResultSet results) throws SQLException{
		ResultSetMetaData rsmd = results.getMetaData();
		ArrayList<String> cols = new ArrayList<String>();
		ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
		
		this.getColumnNamesAsList(cols, rsmd);
		this.iterateOverResultSet(results, data, cols);

	    for (ArrayList<String> resultSet : data) {
	    	System.out.println();
			for (String item : resultSet) {
				System.out.print(item + " ");
			}
		}
		
	    return data;
	}	
	
	private void iterateOverResultSet(ResultSet results, ArrayList<ArrayList<String>> data, 
			ArrayList<String> col_list) throws SQLException{
		int y = 0;
		while(results.next()){
			data.add(new ArrayList<String>());
			for (String col : col_list) {
				data.get(y).add(results.getString(col));
			}
			y++;
		}	
	}
	
	private void getColumnNamesAsList(ArrayList<String> col_list, ResultSetMetaData rsmd) throws SQLException{
		int i = 1;	
		while(i <= rsmd.getColumnCount()){
			col_list.add(rsmd.getColumnName(i));
			i++;
		}
	}
}
