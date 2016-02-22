package de.tetris.steuerungsschicht;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import de.tetris.darstellungsschicht.Frame;
import de.tetris.darstellungsschicht.FrameLoginScreen;

public class LoginScreenListener implements ActionListener{

	private Frame frame;

	public LoginScreenListener(Frame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			if(((JButton) e.getSource()).getText().equals("Submit")) {
				// Funktion hinzufügen
			}
			if(((JButton) e.getSource()).getText().equals("User anlgegen")) {
				// Funktion hinzufügen
			}
		}
	}
}
