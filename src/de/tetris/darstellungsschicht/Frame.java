package de.tetris.darstellungsschicht;

import java.awt.Color;

public class Frame extends GUI{
	private static final int H�HE = 800;
	private static final int BREITE = H�HE / 100 * 90; 
	
	public Frame() {
		super("Tetriges Tetris");
		setSize(BREITE, H�HE);
		setBackground(Color.gray);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}
}
