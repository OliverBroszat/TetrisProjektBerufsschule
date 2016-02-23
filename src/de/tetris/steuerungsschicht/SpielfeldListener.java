package de.tetris.steuerungsschicht;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

public class SpielfeldListener implements KeyListener{

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			System.out.println("PRESSED:     LEFT");
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			System.out.println("PRESSED:     RIGHT");
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			System.out.println("PRESSED:     DOWN");
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			System.out.println("PRESSED:     UP");
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			System.out.println("PRESSED:     SPACE");
		}
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.out.println("PRESSED:     ESCAPE");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			System.out.println("RELEASED:     LEFT");
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			System.out.println("RELEASED:     RIGHT");
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			System.out.println("RELEASED:     DOWN");
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			System.out.println("RELEASED:     UP");
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			System.out.println("RELEASED:     SPACE");
		}
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.out.println("RELEASED:     ESCAPE");
		}		
	}

	@Override
	public void keyTyped(KeyEvent e) {		
	}
}
