package de.tetris.steuerungsschicht.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import de.tetris.darstellungsschicht.Frame;
import de.tetris.steuerungsschicht.Spielfeld;

public class SpielfeldListener implements KeyListener{

	private Frame frame;
	private Spielfeld spielfeld;
		
	public SpielfeldListener(Frame frame, Spielfeld spielfeld) {
		super();
		this.frame = frame;
		this.spielfeld = spielfeld;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			spielfeld.move("left");
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			spielfeld.move("right");
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			spielfeld.move("down");
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
