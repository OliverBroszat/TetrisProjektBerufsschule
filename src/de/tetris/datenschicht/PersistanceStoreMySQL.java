package de.tetris.datenschicht;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersistanceStoreMySQL extends PersistanceStore{
	
	// Handler
	private SelectHandler selectHandler;
	private UpdateHandler updateHandler;
	
	private Connection connection;

	private String hostaddress;
	private String port = "3306";
	private String database;
	private String username = "root";
	
	public SelectHandler getSelectHandler() {
		return selectHandler;
	}
	
	public ArrayList<ArrayList<String>> select(String statement){
		return this.selectHandler.select(statement);
	}
	
	public void update(String statement){
		this.updateHandler.update(statement);
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
			
			this.selectHandler = new SelectHandler();
			this.updateHandler = new UpdateHandler();
			
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
			BasicHandler.conn = this.connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this.connectionStatus;
	}
}
