package de.tetris.darstellungsschicht;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

public class FrameLoginScreen extends Panel{

	private JButton loginButton = new JButton();
	private JButton highScoreButton = new JButton();
	private JLabel titelLabel = new JLabel("Der Tetris");

	public FrameLoginScreen() {
	    setLayout(null);
	    setBackground(Color.gray);
	    
	    titelLabel.setFont(new Font("Arial", Font.BOLD, 46));
	    titelLabel.setForeground(Color.BLUE);
	    highScoreButton.setFont(new Font("Arial", Font.BOLD, 14));
	    loginButton.setFont(new Font("Arial", Font.BOLD, 14));
	    
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
