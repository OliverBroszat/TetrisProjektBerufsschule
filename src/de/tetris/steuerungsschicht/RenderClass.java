package de.tetris.steuerungsschicht;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class RenderClass {
	private Canvas canvas;
	private BufferStrategy bufferstrategy;
	
	public RenderClass(Canvas canvas) {
		this.canvas = canvas;
	}
	
	public void render(){
		if(canvas.getBufferStrategy() == null){
			canvas.createBufferStrategy(2);
		}
		
		Graphics g = canvas.getBufferStrategy().getDrawGraphics();
		
		renderBloecke(g);
		
		g.dispose();
		canvas.getBufferStrategy().show();
	}

	private void renderBloecke(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(0, 0, 100, 100);
	}
}
