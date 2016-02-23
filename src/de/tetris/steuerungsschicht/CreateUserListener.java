package de.tetris.steuerungsschicht;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CreateUserListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() instanceof JButton) {
			if(((JButton) arg0.getSource()).getText().equals("User anlgegen")) {		// Button noch hinzufügen
				//	Funktion hinzufügen
			}
		}
		
	}

}
