package de.tetris.steuerungsschicht.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import de.tetris.darstellungsschicht.Frame;


public class LoginScreenListener implements ActionListener{

	private Frame frame;

	public LoginScreenListener(Frame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			if(((JButton) e.getSource()).getText().equals("Submit")) {
				frame.getCardLayout().show(frame.getBackgroundFrame(), "HauptMenue");
			}
			if(((JButton) e.getSource()).getText().equals("User anlegen")) {
				frame.getCardLayout().show(frame.getBackgroundFrame(), "CreateUser");
			}
		}
	}
}
