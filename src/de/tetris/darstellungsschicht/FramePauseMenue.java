package de.tetris.darstellungsschicht;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class FramePauseMenue extends FrameBasicFrame {
	private Panel panelPause = new Panel();
	private Panel panelButton = new Panel();
	private JLabel titelLabel = new JLabel("Pause", SwingConstants.CENTER);

	public FramePauseMenue() {
		panelPause.setLayout(new BorderLayout());
		panelButton.setLayout(new GridLayout(5, 1));

		panelButton.add(new JLabel());
		panelButton.add(new JLabel());
		panelButton.add(titelLabel);
		panelButton.add(new JLabel());
		panelButton.add(new JLabel());

		panelPause.add(panelButton, BorderLayout.CENTER);

		titelLabel.setFont(super.HeadlineFont);

		super.setCenterFrame(panelPause);
	}
}
