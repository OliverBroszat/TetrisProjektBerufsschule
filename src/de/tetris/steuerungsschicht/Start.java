package de.tetris.steuerungsschicht;
public class Start {
	public static void main(String[] args) {
		Controller game = new Controller();
		game.gameLoop();
		
		System.out.println("Programm hat gestartet.");
	}
}