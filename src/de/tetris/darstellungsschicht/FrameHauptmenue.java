package de.tetris.darstellungsschicht;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

public class FrameHauptmenue extends Panel{

	private JButton loginButton = new JButton();
	private JButton highScoreButton = new JButton();
	private JLabel titelLabel = new JLabel("Der Tetris");

	public FrameHauptmenue() {
	    setLayout(null);
	    setBackground(Color.gray);
	    
	    titelLabel.setFont(super.HeadlineFont);
	    titelLabel.setForeground(Color.BLUE);
	    highScoreButton.setFont(super.font);
	    loginButton.setFont(super.font);
	    
	    loginButton.setText("Login");
	    highScoreButton.setText("Highscore");
	    
	    titelLabel.setBounds(295,100,300,70);
	    highScoreButton.setBounds(260,200,300,70);
	    loginButton.setBounds(260,300,300,70); 

	    add(titelLabel);
	    add(highScoreButton);
	    add(loginButton);
	}
}
