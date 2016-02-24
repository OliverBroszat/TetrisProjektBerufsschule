package de.tetris.steuerungsschicht;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import de.tetris.darstellungsschicht.FrameBasicFrame;
import de.tetris.steuerungsschicht.Listener.BasicFrameListener;

public class RenderClass {
	private Canvas canvas;
	private BufferStrategy bufferstrategy;
	private Block[][] spielfeld;

	public RenderClass(Canvas canvas, Block[][] spielfeld) {
		this.canvas = canvas;
		this.spielfeld = spielfeld;
	}

	public void render() {
		if (canvas.getBufferStrategy() == null) {
			canvas.createBufferStrategy(2);
			bufferstrategy = canvas.getBufferStrategy();
		}

		Graphics g = bufferstrategy.getDrawGraphics();

		renderBloecke(g);

		g.dispose();
		bufferstrategy.show();
	}

	private void renderBloecke(Graphics g) {
		int size = FrameBasicFrame.BLOCK_SIZE;
		
		for (int i = 0; i < spielfeld.length; i++) {
			for (int j = 0; j < spielfeld[i].length; j++) {
				if (spielfeld[i][j] != null) {
					System.out.println("Color: " + spielfeld[i][j].getColor());
					g.setColor(spielfeld[i][j].getColor());
				} else {
					g.setColor(Color.white);
				}
				g.fillRect(j * size, i * size, size, size);
			}
		}

	}
}
