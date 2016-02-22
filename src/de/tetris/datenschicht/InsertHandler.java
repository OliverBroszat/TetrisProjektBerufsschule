package de.tetris.datenschicht;

public class InsertHandler extends BasicHandler{
	public void insert(String statement) {
		super.createUpdateStatement(statement);
	}
}
