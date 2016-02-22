package de.tetris.steuerungsschicht;

import java.util.ArrayList;
import java.util.List;

public abstract class Form {
	protected List<Block> blockList = new ArrayList<Block>();
	private int anzahlBloecke;
	
	
	public Form() {
		super();
		formeBlock();
	}

	public abstract void formeBlock();
}
