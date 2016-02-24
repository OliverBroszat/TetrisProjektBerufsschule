package de.tetris.darstellungsschicht;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class FramePauseMenue extends FrameBasicFrame{
	private Panel panelPause = new Panel();
	private Panel panelButton = new Panel();
	private JButton hauptmenueButton = new JButton("Hauptmenü");
	private JButton speichernButton = new JButton("Speichern");
	private JLabel titelLabel = new JLabel("Pause", SwingConstants.CENTER);
	
	public FramePauseMenue() {
		panelPause.setLayout(new BorderLayout());
		panelButton.setLayout(new GridLayout(5, 1));
		
		panelButton.add(titelLabel);
		panelButton.add(new JLabel());
		panelButton.add(hauptmenueButton);
		panelButton.add(new JLabel());
		panelButton.add(speichernButton);
	
		panelPause.add(panelButton, BorderLayout.CENTER);
		
		
		titelLabel.setFont(super.HeadlineFont);
		
		super.setCenterFrame(panelPause);
	}
}
