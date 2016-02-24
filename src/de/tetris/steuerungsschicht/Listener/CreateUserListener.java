package de.tetris.steuerungsschicht.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import de.tetris.darstellungsschicht.Frame;

public class CreateUserListener extends BasicActionListener{

	public CreateUserListener(Frame frame) {
		super(frame);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() instanceof JButton) {
			if(((JButton) arg0.getSource()).getText().equals("User anlegen")) {		// Button noch hinzufügen
				frame.getCardLayout().show(frame.getBackgroundFrame(), "HauptMenue");
			}
		}
	}
}
