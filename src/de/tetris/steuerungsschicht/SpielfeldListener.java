package de.tetris.steuerungsschicht;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SpielfeldListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			// Buttons noch hinzufügen
			if(((JButton) e.getSource()).getText().equals("")) {
				// Funktion hinzufügen
			}
		}
	}

}
