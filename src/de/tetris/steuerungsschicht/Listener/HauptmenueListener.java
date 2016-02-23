package de.tetris.steuerungsschicht.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import de.tetris.darstellungsschicht.Frame;


public class HauptmenueListener implements ActionListener{
	private Frame frame;

	public HauptmenueListener(Frame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			if(((JButton) e.getSource()).getText().equals("Login")) {
				frame.getCardLayout().show(frame.getBackgroundFrame(), "Login");
			}
			else if(((JButton) e.getSource()).getText().equals("Highscore")) {
				frame.getCardLayout().show(frame.getBackgroundFrame(), "Highscore");
			}
			else if(((JButton) e.getSource()).getText().equals("Spiel starten")) {
				frame.getCardLayout().show(frame.getBackgroundFrame(), "Spielfeld");
				frame.getController().spielfedRequestFocus(frame.getPanelSpielfeld());
			}
		}
	}
}