package de.tetris.datenschicht;

import java.sql.ResultSet;

public class UpdateHandler extends BasicHandler{
	public void update(String statement) {
		super.createUpdateStatement(statement);
	}
}
