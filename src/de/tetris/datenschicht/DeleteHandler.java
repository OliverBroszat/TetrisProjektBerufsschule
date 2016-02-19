package de.tetris.datenschicht;

public class DeleteHandler extends BasicHandler{
	public void delete(String statement) {
		System.out.println("INFO: " + statement);
		super.createUpdateStatement(statement);
	}
}
