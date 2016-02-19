package de.tetris.steuerungsschicht;

import java.util.ArrayList;
import java.util.List;

public abstract class Form {
	List blockList = new ArrayList<Block>();
	private Block startBlock;
	private int anzahlBloecke;
	
	public void formeBlock() {
		startBlock = new Block();
		anzahlBloecke = 0;
		pruefeNachbar(startBlock);		
	}
	
	private void pruefeNachbar(Block blockRichtung) {
		if(anzahlBloecke <= 3) {
			Block block = new Block();
			int zufall = (int)((Math.random()*4)+1);
			anzahlBloecke = anzahlBloecke + 1;
			switch (zufall) {
			case 1 :	if(blockRichtung.getNachbarRechts() != null) {
							blockRichtung.setNachbarRechts(block);
							pruefeNachbar(blockRichtung.getNachbarRechts());
						}
						break;
			case 2 :	if(blockRichtung.getNachbarUnten() != null) {
							blockRichtung.setNachbarUnten(block);
							pruefeNachbar(blockRichtung.getNachbarUnten());
						}
						break;
			case 3 :	if(blockRichtung.getNachbarLinks() != null) {
							blockRichtung.setNachbarLinks(block);
							pruefeNachbar(blockRichtung.getNachbarLinks());
						}
						break;
			case 4 :	if(blockRichtung.getNachbarOben() != null) {
							blockRichtung.setNachbarOben(block);
							pruefeNachbar(blockRichtung.getNachbarOben());
						}
						break;
			default:
							}
		}
	}
}
