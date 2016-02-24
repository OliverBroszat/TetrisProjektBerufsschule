package de.tetris.darstellungsschicht;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class FrameLoginScreen extends Panel{
	
	private JLabel titelLabel = new JLabel("Login");
	private JLabel nameLabel = new JLabel("Username: ");
	private JTextField nameTextField = new JTextField();
	private JLabel passwortLabel = new JLabel("Passwort: ");
	private JPasswordField passwortField = new JPasswordField();	
	private JButton submitButton = new JButton("Submit");
	private JButton newUserButton = new JButton("User anlegen");
	
	private JPanel centerPanel = new JPanel();

	public FrameLoginScreen() {		
	    setLayout(null);
	    setBackground(Color.gray);
	    
	    titelLabel.setFont(super.HeadlineFont);
	    submitButton.setFont(super.font);
	    nameLabel.setFont(super.font);
	    nameTextField.setFont(super.font);
	    passwortLabel.setFont(super.font);
	    newUserButton.setFont(super.font);
	    
	    centerPanel.setLayout(new GridLayout(2,2));
	    centerPanel.setAlignmentX(20);
	    centerPanel.setAlignmentY(20);
	    centerPanel.setBackground(Color.lightGray);
	    
	    centerPanel.setBounds(200,250,400,270);
	    centerPanel.add(nameLabel);
	    centerPanel.add(nameTextField);
	    centerPanel.add(passwortLabel);
	    centerPanel.add(passwortField);
	    
	    titelLabel.setForeground(Color.BLUE);    
	    titelLabel.setBounds(340,100,300,70);	   
	    submitButton.setBounds(400,550,200,70);
	    newUserButton.setBounds(200, 550, 200, 70);
	    

	    add(titelLabel);
	    add(submitButton);
	    add(newUserButton);
	    add(centerPanel);
	}

	public JButton getSubmitButton() {
		return submitButton;
	}

	public JButton getNewUserButton() {
		return newUserButton;
	}
}
