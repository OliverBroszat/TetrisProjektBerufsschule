package de.tetris.darstellungsschicht;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class FrameCreateUser extends Panel{
	
	private JLabel titelLabel = new JLabel("Create User");
	private JLabel nameLabel = new JLabel("Username: ");
	private JTextField nameTextField = new JTextField();
	private JLabel passwortLabel = new JLabel("Passwort: ");
	private JPasswordField passwortField = new JPasswordField();	
	private JLabel checkPasswortLabel = new JLabel("Passwort: ");
	private JPasswordField checkPasswortField = new JPasswordField();
	private JButton newUserButton = new JButton("User anlgegen");
	
	private JPanel centerPanel = new JPanel();

	public FrameCreateUser() {		
	    setLayout(null);
	    setBackground(Color.gray);
	    
	    titelLabel.setFont(super.HeadlineFont);
	    nameLabel.setFont(super.font);
	    nameTextField.setFont(super.font);
	    passwortLabel.setFont(super.font);
	    checkPasswortLabel.setFont(super.font);
	    newUserButton.setFont(super.font);
	    
	    centerPanel.setLayout(new GridLayout(3,2));
	    centerPanel.setBackground(Color.lightGray);
	    
	    centerPanel.setBounds(200,250,400,270);
	    centerPanel.add(nameLabel);
	    centerPanel.add(nameTextField);
	    centerPanel.add(passwortLabel);
	    centerPanel.add(passwortField);
	    centerPanel.add(checkPasswortLabel);
	    centerPanel.add(checkPasswortField);
	    
	    titelLabel.setForeground(Color.BLUE);    
	    titelLabel.setBounds(340,100,300,70);	   
	    newUserButton.setBounds(400, 650, 200, 70);
	    checkPasswortLabel.setBounds(400,500,200,70);
	    
	    add(titelLabel);
	    add(newUserButton);
	    add(centerPanel);
	}
}
