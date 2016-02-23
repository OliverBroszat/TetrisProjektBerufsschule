package de.tetris.steuerungsschicht.Listener;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import de.tetris.darstellungsschicht.Frame;

public class PausemenueListener extends BasicActionListener {

	public PausemenueListener(Frame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			if (((JButton) e.getSource()).getText().equals("Hauptmenü")) {
				frame.getCardLayout().show(frame.getBackgroundFrame(),
						"HauptMenue");
				frame.getController().stopGame();
			} else if (((JButton) e.getSource()).getText().equals("Speichern")) {
				System.out.println("Implement me");
			}
		}
	}
}
