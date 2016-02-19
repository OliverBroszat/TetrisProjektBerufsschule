package de.tetris.steuerungsschicht;

import java.util.ArrayList;
import java.util.List;

public abstract class Form {
	List blockList = new ArrayList<Block>();
	
	public void formeBlock() {
		Block  hauptBlock = new Block();
		int zufall = (int)((Math.random()*4)+1);
	}
	
	public void pruefeNachbar() {
		
	}
	
	public void waehleRichtung() {
		
	}
}
