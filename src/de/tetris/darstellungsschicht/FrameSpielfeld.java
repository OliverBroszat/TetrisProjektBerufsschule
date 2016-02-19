package de.tetris.darstellungsschicht;

import java.awt.Color;

public class FrameSpielfeld extends FrameBasicFrame{
	
	private Panel panelSpielfeld = new Panel();

	public FrameSpielfeld() {
	    panelSpielfeld.setBackground(Color.white);			
	    setCenterFrame(panelSpielfeld);
	}
}
