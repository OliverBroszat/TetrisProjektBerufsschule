package de.tetris.steuerungsschicht;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class HauptmenueListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			if(((JButton) e.getSource()).getText().equals("Login")) {
				// Funktion hinzufügen
			}
			if(((JButton) e.getSource()).getText().equals("Highscore")) {
				// Funktion hinzufügen
			}
		}
	}
}
