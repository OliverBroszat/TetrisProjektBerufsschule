package de.tetris.steuerungsschicht;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class LoginScreenListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			if(((JButton) e.getSource()).getText().equals("Submit")) {
				// Funktion hinzuf�gen
			}
			if(((JButton) e.getSource()).getText().equals("User anlgegen")) {
				// Funktion hinzuf�gen
			}
		}
	}
}
