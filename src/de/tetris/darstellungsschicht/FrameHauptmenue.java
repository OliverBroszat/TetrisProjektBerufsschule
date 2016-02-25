package de.tetris.darstellungsschicht;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

public class FrameHauptmenue extends Panel{

	private JButton loginButton = new JButton();
	private JButton highScoreButton = new JButton();
	private JLabel titelLabel = new JLabel("Der Tetris");
	private JButton startenButton = new JButton("Spiel starten");
	private JButton ladenButton = new JButton("Spiel laden");

	public FrameHauptmenue() {
	    setLayout(null);
	    setBackground(Color.gray);
	    
	    titelLabel.setFont(super.HeadlineFont);
	    titelLabel.setForeground(Color.BLUE);
	    highScoreButton.setFont(super.font);
	    loginButton.setFont(super.font);
	    startenButton.setFont(super.font);
	    ladenButton.setFont(super.font);
	    
	    loginButton.setText("Login");
	    highScoreButton.setText("Highscore");
	    
	    titelLabel.setBounds(245,100,300,70);
	    highScoreButton.setBounds(220,200,300,70);
	    loginButton.setBounds(220,300,300,70);
	    startenButton.setBounds(220,400,300,70);
	    ladenButton.setBounds(220,500,300,70);
	    
	    add(ladenButton);
	    add(startenButton);
	    add(titelLabel);
	    add(highScoreButton);
	    add(loginButton);
	}

	public JButton getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(JButton loginButton) {
		this.loginButton = loginButton;
	}

	public JButton getHighScoreButton() {
		return highScoreButton;
	}

	public void setHighScoreButton(JButton highScoreButton) {
		this.highScoreButton = highScoreButton;
	}

	public JButton getStartenButton() {
		return startenButton;
	}

	public void setStartenButton(JButton startenButton) {
		this.startenButton = startenButton;
	}

	public JButton getLadenButton() {
		return ladenButton;
	}
	
}
