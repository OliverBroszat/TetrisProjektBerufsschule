package de.tetris.datenschicht;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserHandler extends BasicHandler{
	
	@Override
	public ArrayList<ArrayList<String>> select(String statement) {
		return super.evaluateStatement(super.createStatement(statement));
	}

	@Override
	public boolean insert(String statement) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String statement) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(String statement) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
