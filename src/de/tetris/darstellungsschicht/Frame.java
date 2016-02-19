package de.tetris.darstellungsschicht;

import java.awt.Color;

public class Frame extends GUI{
	private static final int HÖHE = 800;
	private static final int BREITE = HÖHE / 100 * 90; 
	
	public Frame() {
		super("Tetriges Tetris");
		setSize(BREITE, HÖHE);
		setBackground(Color.gray);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}
}
