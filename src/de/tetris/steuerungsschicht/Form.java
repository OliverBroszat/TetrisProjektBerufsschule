package de.tetris.steuerungsschicht;

import java.util.ArrayList;
import java.util.List;

public abstract class Form {
	protected List<Block> blockList = new ArrayList<Block>();
	private int anzahlBloecke;
	
	public Form() {
		formeBlock();
	}
	
	protected void emptyList(){
		this.blockList.clear();
	}

	public abstract void formeBlock();
}
