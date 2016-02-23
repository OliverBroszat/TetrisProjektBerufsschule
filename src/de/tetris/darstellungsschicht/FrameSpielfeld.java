package de.tetris.darstellungsschicht;

import java.awt.Canvas;
import java.awt.Color;

public class FrameSpielfeld extends FrameBasicFrame{
	
	private Canvas canvas = new Canvas();

	public FrameSpielfeld() {
	    canvas.setBackground(Color.white);			
	    setCenterFrame(canvas);
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
}
