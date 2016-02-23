package de.tetris.steuerungsschicht.Listener;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import de.tetris.darstellungsschicht.Frame;

public class HighscoreListener extends BasicActionListener {

	public HighscoreListener(Frame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			if (((JButton) e.getSource()).getText().equals("Zurück")) {
				frame.getCardLayout().show(frame.getBackgroundFrame(), "HauptMenue");
			}
		}
	}

}
