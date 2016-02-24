package de.tetris.darstellungsschicht;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

public class FrameBasicFrame extends Panel{
	private Panel panelNaechsterBlock = new Panel();
	private JLabel scoreLabel = new JLabel("Score: ");
	private JButton pauseButton = new JButton("Pause");

	public FrameBasicFrame() {
	    setLayout(null);
	    setBackground(Color.gray);
	    
	    
	    panelNaechsterBlock.setBackground(Color.blue);
	    
	    pauseButton.setFont(super.font);
	    scoreLabel.setFont(new Font("Arial", Font.BOLD, 14));
		
	    panelNaechsterBlock.setBounds(580,10,200,200);
	    scoreLabel.setBounds(580,150,200,200);  
	    pauseButton.setBounds(580,300,200,80);  

	    add(pauseButton);
	    add(scoreLabel);
	    add(panelNaechsterBlock);
	}
	
	public void setCenterFrame(Panel panel){
		panel.setBounds(10,10,550,750);
		add(panel);
	}
	public void setCenterFrame(Canvas canvas){
		canvas.setBounds(10,10,550,750);
		add(canvas);
	}
}
