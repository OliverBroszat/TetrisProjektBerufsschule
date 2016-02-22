package de.tetris.datenschicht;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class SelectHandler extends BasicHandler{
	public ArrayList<ArrayList<String>> select(String statement) {
		return evaluateStatement(createExecuteStatement(statement));
	}

	protected ArrayList<ArrayList<String>> evaluateStatement(ResultSet results){
		ResultSetMetaData rsmd = null;
		ArrayList<String> cols = null;
		ArrayList<ArrayList<String>> data = null;
		try {
			rsmd = results.getMetaData();
			
			cols = new ArrayList<String>();
			data = new ArrayList<ArrayList<String>>();
			
			this.getColumnNamesAsList(cols, rsmd);
			this.iterateOverResultSet(results, data, cols);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return data;
	}	
	
	private void iterateOverResultSet(ResultSet results, ArrayList<ArrayList<String>> data, 
			ArrayList<String> col_list){
		
		int y = 0;
		try {
			while(results.next()){
				data.add(new ArrayList<String>());
				for (String col : col_list) {
					data.get(y).add(results.getString(col));
				}
				y++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	private void getColumnNamesAsList(ArrayList<String> col_list, ResultSetMetaData rsmd){
		int i = 1;	
		
		try {
			while(i <= rsmd.getColumnCount()){
				col_list.add(rsmd.getColumnName(i));
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
