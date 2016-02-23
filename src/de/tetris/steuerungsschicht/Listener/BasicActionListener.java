package de.tetris.steuerungsschicht.Listener;

import java.awt.event.ActionListener;
import de.tetris.darstellungsschicht.Frame;

public abstract class BasicActionListener implements ActionListener{

	protected Frame frame;
	
	public BasicActionListener(Frame frame) {
	this.frame = frame;
	}
}
