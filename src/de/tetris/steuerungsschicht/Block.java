package de.tetris.steuerungsschicht;

public class Block {

	private Block nachbarOben;
	private Block nachbarRechts;
	private Block nachbarUnten;
	private Block nachbarLinks;
	
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
}
