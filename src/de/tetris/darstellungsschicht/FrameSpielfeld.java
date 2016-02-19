package de.tetris.darstellungsschicht;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class FrameSpielfeld extends Panel{
	
	private Panel panelSpielfeld = new Panel();
	private Panel panelNaechsterBlock = new Panel();
	private JLabel scoreLabel = new JLabel("Score: ");

	public FrameSpielfeld() {
	    setLayout(null);
	    setBackground(Color.gray);
	    
	    panelSpielfeld.setBackground(Color.white);
	    panelNaechsterBlock.setBackground(Color.blue);
	    
	    scoreLabel.setFont(new Font("Arial", Font.BOLD, 14));
			
	    panelSpielfeld.setBounds(10,10,550,750);
	    panelNaechsterBlock.setBounds(580,10,200,200);
	    scoreLabel.setBounds(580,150,200,200);  

	    add(scoreLabel);
	    add(panelSpielfeld);
	    add(panelNaechsterBlock);
	}
}
