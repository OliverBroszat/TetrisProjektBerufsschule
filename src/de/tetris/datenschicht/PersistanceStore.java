package de.tetris.datenschicht;

public abstract class PersistanceStore {
	protected boolean connectionStatus = false;
	protected BasicHandler handler;
	
	
	abstract boolean createConnection(String database);
}
