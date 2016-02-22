package de.tetris.datenschicht;

public class UpdateHandler extends BasicHandler{
	public void update(String statement) {
		System.out.println("INFO: " + statement);
		super.createUpdateStatement(statement);
	}
}
