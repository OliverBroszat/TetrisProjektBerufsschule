package de.tetris.steuerungsschicht;

import java.util.ArrayList;

public class Spielfeld {
	private static final int FIELD_WIDTH = 24;
	private static final int FIELD_HEIGHT = FIELD_WIDTH / 2;
	private Block [][] cubes = new Block[FIELD_WIDTH][FIELD_HEIGHT];
	private ArrayList<Form> formList = new ArrayList<Form>();
	
	private Rotator rotator;
	
	public Spielfeld(){
		initNormalMode();
	}
	
	public void initNormalMode(){
		formList.add(new FormNormalMode());
		formList.add(new FormNormalMode());
		formList.add(new FormNormalMode());
		formList.add(new FormNormalMode());
		
		System.out.println("FORMLIST SIZE:"  + this.formList.size());
		
		Block startBlock = formList.get(0).blockList.get(0);
		
		System.out.println(formList.get(0).blockList.get(0));
		
		this.setBlocks(startBlock);
	}
	
	public void drawCubes(){
		int rows = cubes.length;
		int cols = cubes[0].length;
		
		for (int i = 0; i < rows; i++) {
			System.out.println("");
			for (int j = 0; j < cols; j++) {
				if(cubes[i][j] != null){
					System.out.print(" " + cubes[i][j].getClass().getSimpleName());
				}else{
					System.out.print("   " + cubes[i][j]);
				}
			}
		}
	}
	
	private Block setBlocks(Block currBlock){	
		int x = 2;
		int y = 4;
		cubes[x][y] = currBlock;
		
		if(currBlock.getNachbarLinks() != null){
			System.out.println("Hat links!");
			cubes[y][x - 1] = currBlock.getNachbarLinks();
			this.setBlocks(cubes[y][x - 1]);
		}else if(currBlock.getNachbarRechts() != null){
			System.out.println("Hat rechts!");
			cubes[y][x + 1] = currBlock.getNachbarRechts();
			this.setBlocks(cubes[y][x + 1]);
		}else if(currBlock.getNachbarOben() != null){
			System.out.println("Hat oben!");
			cubes[y-1][x] = currBlock.getNachbarOben();
			this.setBlocks(cubes[y-1][x]);
		}else if(currBlock.getNachbarUnten() != null){
			System.out.println("Hat unten!");
			cubes[y+1][x] = currBlock.getNachbarUnten();
			this.setBlocks(cubes[y+1][x]);
		}else{
			
		}
		
		drawCubes();
		return null;
	}
	
	
	
}
