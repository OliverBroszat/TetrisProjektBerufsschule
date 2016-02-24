package de.tetris.steuerungsschicht;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public abstract class Form {
	protected List<Block> blockList = new ArrayList<Block>();
	private int anzahlBloecke;
	private Color color;

	public Form() {
		super();
		formeBlock();
		color = generateColor();
		setColors();
	}

	public Color generateColor() {
		int r = (int) (Math.random() * 200);
		int g = (int) (Math.random() * 200);
		int b = (int) (Math.random() * 200);
		
		return new Color(r,g,b);
	}
	
	public void setColors(){
		for (int i = 0; i < blockList.size(); i++) {
			blockList.get(i).setColor(color);
		}
	}

	public abstract void formeBlock();
}
