package de.tetris.darstellungsschicht;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class FrameBasicFrame extends Panel{
	private Panel panelNaechsterBlock = new Panel();
	private JLabel scoreLabel = new JLabel("Score: ");

	public FrameBasicFrame() {
	    setLayout(null);
	    setBackground(Color.gray);
	    
	    
	    panelNaechsterBlock.setBackground(Color.blue);
	    
	    scoreLabel.setFont(new Font("Arial", Font.BOLD, 14));
			
	    panelNaechsterBlock.setBounds(580,10,200,200);
	    scoreLabel.setBounds(580,150,200,200);  

	    add(scoreLabel);
	    add(panelNaechsterBlock);
	}
	
	public void setCenterFrame(Panel panel){
		panel.setBounds(10,10,550,750);
		add(panel);
	}
}
