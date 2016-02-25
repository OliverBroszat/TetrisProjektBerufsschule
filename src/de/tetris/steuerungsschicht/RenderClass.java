package de.tetris.steuerungsschicht;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import de.tetris.darstellungsschicht.FrameBasicFrame;
import de.tetris.darstellungsschicht.FrameSpielfeld;
import de.tetris.steuerungsschicht.Listener.BasicFrameListener;

public class RenderClass {
	private Canvas canvasSpielfeld;
	private Canvas canvasNextBlock;
	private Block[][] spielfeld;
	private Block[][] nextBlock;
	private BufferStrategy strategySpielfeld;
	private BufferStrategy strategyNextBlock;

	public RenderClass(FrameSpielfeld frameSpielfeld, Spielfeld spielfeld) {
		this.canvasSpielfeld = frameSpielfeld.getCanvas();
		this.canvasNextBlock = frameSpielfeld.getCanvasNaechsterBlock();
		this.spielfeld = spielfeld.getCubes();
		this.nextBlock = spielfeld.getNextCubes();
	}

	public void render() {
		if (strategySpielfeld == null) {
			canvasSpielfeld.createBufferStrategy(2);
			strategySpielfeld = canvasSpielfeld.getBufferStrategy();
		}
		if (strategyNextBlock == null) {
			canvasNextBlock.createBufferStrategy(2);
			strategyNextBlock = canvasNextBlock.getBufferStrategy();
		}
		System.out.println("spielfeld: " + canvasSpielfeld);
		renderSpielfeld(strategySpielfeld.getDrawGraphics());
		renderNextBlock(strategyNextBlock.getDrawGraphics());

		strategySpielfeld.getDrawGraphics().dispose();
		strategyNextBlock.getDrawGraphics();
		strategyNextBlock.show();
		strategySpielfeld.show();
	}

	private void renderNextBlock(Graphics g) {
		int size = 30;
		
		for (int i = 0; i < nextBlock.length; i++) {
			for (int j = 0; j < nextBlock[i].length; j++) {
				if (nextBlock[i][j] != null) {
					g.setColor(nextBlock[i][j].getColor());
				} else {
					g.setColor(Color.white);
				}
				g.fillRect(j * size, i * size, size, size);
			}
		}
	}

	private void renderSpielfeld(Graphics g) {
		int size = FrameBasicFrame.BLOCK_SIZE;
		
		for (int i = 0; i < spielfeld.length; i++) {
			for (int j = 0; j < spielfeld[i].length; j++) {
				if (spielfeld[i][j] != null) {
					g.setColor(spielfeld[i][j].getColor());
				} else {
					g.setColor(Color.white);
				}
				g.fillRect(j * size, i * size, size, size);
			}
		}

	}
}
