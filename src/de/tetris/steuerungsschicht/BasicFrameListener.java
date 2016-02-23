package de.tetris.steuerungsschicht;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import de.tetris.darstellungsschicht.Frame;
import de.tetris.darstellungsschicht.FrameSpielfeld;

public class BasicFrameListener implements ActionListener{

	private Frame frame;
	
	public BasicFrameListener(Frame frame) {
	this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() instanceof JButton) {
			if(((JButton) arg0.getSource()).getText().equals("")) {		// Button noch hinzufügen
			}
		}
	}
}
