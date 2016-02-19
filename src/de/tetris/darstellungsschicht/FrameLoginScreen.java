package de.tetris.darstellungsschicht;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextField;

public class FrameLoginScreen extends Panel{

	private JButton loginButton = new JButton();
	private JButton highScoreButton = new JButton();
	private JTextField titelTextField = new JTextField();

	public FrameLoginScreen() {
	    setLayout(null);
	    
	    highScoreButton.setFont(new Font("Arial", Font.BOLD, 14));
	    loginButton.setFont(new Font("Arial", Font.BOLD, 14));
	    
	    loginButton.setText("Login");
	    highScoreButton.setText("Highscore");
	    
	    setBackground(Color.gray);
	    highScoreButton.setBounds(260,200,300,70);
	    loginButton.setBounds(260,300,300,70); 

	    add(highScoreButton);
	    add(loginButton);
	}
}
