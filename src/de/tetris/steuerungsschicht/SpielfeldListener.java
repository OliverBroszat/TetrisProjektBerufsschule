package de.tetris.steuerungsschicht;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SpielfeldListener implements KeyListener{

	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_LEFT) {
			System.out.println("PRESSED:     LEFT");
		}
		if(arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
			System.out.println("PRESSED:     RIGHT");
		}
		if(arg0.getKeyCode() == KeyEvent.VK_DOWN) {
			System.out.println("PRESSED:     DOWN");
		}
		if(arg0.getKeyCode() == KeyEvent.VK_UP) {
			System.out.println("PRESSED:     UP");
		}
		if(arg0.getKeyCode() == KeyEvent.VK_SPACE) {
			System.out.println("PRESSED:     SPACE");
		}
		if(arg0.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.out.println("PRESSED:     ESCAPE");
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_LEFT) {
			System.out.println("RELEASED:     LEFT");
		}
		if(arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
			System.out.println("RELEASED:     RIGHT");
		}
		if(arg0.getKeyCode() == KeyEvent.VK_DOWN) {
			System.out.println("RELEASED:     DOWN");
		}
		if(arg0.getKeyCode() == KeyEvent.VK_UP) {
			System.out.println("RELEASED:     UP");
		}
		if(arg0.getKeyCode() == KeyEvent.VK_SPACE) {
			System.out.println("RELEASED:     SPACE");
		}
		if(arg0.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.out.println("RELEASED:     ESCAPE");
		}		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_LEFT) {
			System.out.println("TYPED:     LEFT");
		}
		if(arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
			System.out.println("TYPED:     RIGHT");
		}
		if(arg0.getKeyCode() == KeyEvent.VK_DOWN) {
			System.out.println("TYPED:     DOWN");
		}
		if(arg0.getKeyCode() == KeyEvent.VK_UP) {
			System.out.println("TYPED:     UP");
		}
		if(arg0.getKeyCode() == KeyEvent.VK_SPACE) {
			System.out.println("TYPED:     SPACE");
		}
		if(arg0.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.out.println("TYPED:     ESCAPE");
		}		
	}

}
