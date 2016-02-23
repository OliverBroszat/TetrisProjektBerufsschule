package de.tetris.steuerungsschicht;

import java.awt.Color;
import java.io.Serializable;

public class Block implements Serializable{

	private Block nachbarOben;
	private Block nachbarRechts;
	private Block nachbarUnten;
	private Block nachbarLinks;
	private Color color;
	
	/**
	 * Überlegung ob Farbwahl in Form/Controller anstatt Attribut
	*/
	
	public Block getNachbarOben() {
		return nachbarOben;
	}
	
	public void setNachbarOben(Block nachbarOben) {
		this.nachbarOben = nachbarOben;
	}
	
	public Block getNachbarRechts() {
		return nachbarRechts;
	}
	
	public void setNachbarRechts(Block nachbarRechts) {
		this.nachbarRechts = nachbarRechts;
	}
	
	public Block getNachbarUnten() {
		return nachbarUnten;
	}
	
	public void setNachbarUnten(Block nachbarUnten) {
		this.nachbarUnten = nachbarUnten;
	}
	
	public Block getNachbarLinks() {
		return nachbarLinks;
	}
	
	public void setNachbarLinks(Block nachbarLinks) {
		this.nachbarLinks = nachbarLinks;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public Color getColor(){
		return color;
	}
}
