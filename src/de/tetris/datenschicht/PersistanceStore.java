package de.tetris.datenschicht;

public abstract class PersistanceStore {
	protected boolean connectionStatus = false;
	
	
	abstract boolean createConnection(String database);
}
