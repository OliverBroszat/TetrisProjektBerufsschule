package de.tetris.darstellungsschicht;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class FrameBasicFrame extends Panel{
	public static final int BLOCK_SIZE = 40;
	private static final int FIELD_HEIGHT = 20;
	private static final int FIELD_WIDTH = 12;
	private Canvas canvasNaechsterBlock = new Canvas();
	private JLabel scoreLabel = new JLabel("Score: ");
	private JButton pauseButton = new JButton("Pause");
	private JButton hauptmenueButton = new JButton("Hauptmenü");
	private JButton speichernButton = new JButton("Speichern");

	public FrameBasicFrame() {
	    setLayout(null);
	    setBackground(Color.gray);
	    
	    
	    canvasNaechsterBlock.setBackground(Color.white);
	    
	    pauseButton.setFont(super.font);
	    scoreLabel.setFont(new Font("Arial", Font.BOLD, 14));
	    hauptmenueButton.setFont(super.font);
	    speichernButton.setFont(super.font);;
		
	    canvasNaechsterBlock.setBounds(500,10,200,200);
	    scoreLabel.setBounds(500,220,50,50);  
	    pauseButton.setBounds(500,300,200,80);
	    hauptmenueButton.setBounds(500,400,200,80);
	    speichernButton.setBounds(500,500,200,80);

	    add(hauptmenueButton);
	    add(speichernButton);
	    add(pauseButton);
	    add(scoreLabel);
	    add(canvasNaechsterBlock);
	}
	
	public void setCenterFrame(Panel panel){
		panel.setBounds(10,10, BLOCK_SIZE * FIELD_WIDTH, BLOCK_SIZE * FIELD_HEIGHT);
		add(panel);
	}
	public void setCenterFrame(Canvas canvas){
		canvas.setBounds(10,10, BLOCK_SIZE * FIELD_WIDTH, BLOCK_SIZE * FIELD_HEIGHT);
		add(canvas);
	}

	public JLabel getScoreLabel() {
		return scoreLabel;
	}

	public void setScoreLabel(JLabel scoreLabel) {
		this.scoreLabel = scoreLabel;
	}

	public JButton getPauseButton() {
		return pauseButton;
	}

	public Canvas getCanvasNaechsterBlock() {
		return canvasNaechsterBlock;
	}

	public JButton getHauptmenueButton() {
		return hauptmenueButton;
	}

	public JButton getSpeichernButton() {
		return speichernButton;
	}
}
