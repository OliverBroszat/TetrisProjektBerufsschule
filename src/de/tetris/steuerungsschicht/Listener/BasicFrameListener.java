package de.tetris.steuerungsschicht.Listener;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import de.tetris.darstellungsschicht.Frame;

public class BasicFrameListener extends BasicActionListener {

	public BasicFrameListener(Frame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
	}

	// TODO Marvin/Oliver buttons/keys checken und implementieren
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			if (((JButton) e.getSource()).getText().equals("Pause")) {
				System.out.println("ist ne Pausenbutton");
				if (frame.getController().getPause()) {
					frame.getCardLayout().show(frame.getBackgroundFrame(),
							"Spielfeld");
					frame.getController().setPause(false);
					frame.getController().spielfedRequestFocus(
							frame.getPanelSpielfeld());
				} else {
					frame.getCardLayout().show(frame.getBackgroundFrame(),
							"PauseMenue");
					frame.getController().setPause(true);
				}
			}
			if (((JButton) e.getSource()).getText().equals("Hauptmenü")) {
				frame.getCardLayout().show(frame.getBackgroundFrame(),
						"HauptMenue");
				frame.getController().stopGame();
			} else if (((JButton) e.getSource()).getText().equals("Speichern")) {
				frame.getController().getSpielfeld().serialize();
				System.out.println("save");
			}
		}
	}

}
