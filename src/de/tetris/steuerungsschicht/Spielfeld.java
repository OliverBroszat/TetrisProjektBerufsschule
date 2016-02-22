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
		
		formList.get(0).blockList.get(0).getNachbarLinks();	
		
		System.out.println("FORMLIST SIZE:"  + this.formList.size());
		
		Block startBlock = formList.get(0).blockList.get(0);
		System.out.println(formList.get(0).blockList.size());
		
		this.setBlocks(startBlock, 2, 4);
		
		
	}
	
	public void drawCubes(){
		int row = cubes.length;
		int col = cubes[0].length;
		
		for (int i = 0; i < cubes.length; i++) {
			System.out.println("DIM " + i);
			for (int j = 0; j < cubes[0].length; j++) {
				if(cubes[i][j] != null){
					System.out.print(" " + cubes[i][j].getClass().getSimpleName());
				}else{
					System.out.print("  " + cubes[i][j]);
				}
			}
		}
	}
	
	private Block setBlocks(Block startBlock,int x,int y){
		
		
		cubes[x][y] = startBlock;
		if(startBlock.getNachbarLinks() != null){
			System.out.println("Hat links!");
			cubes[2][3] = startBlock.getNachbarLinks();
			this.setBlocks(cubes[2][3]);
		}else if(startBlock.getNachbarRechts() != null){
			System.out.println("Hat rechts!");
			cubes[2][5] = startBlock.getNachbarRechts();
			this.setBlocks(cubes[2][5]);
		}else if(startBlock.getNachbarOben() != null){
			System.out.println("Hat oben!");
			cubes[1][4] = startBlock.getNachbarRechts();
			this.setBlocks(cubes[1][4]);
		}else if(startBlock.getNachbarUnten() != null){
			System.out.println("Hat unten!");
			cubes[3][4] = startBlock.getNachbarUnten();
			this.setBlocks(cubes[3][4]);
		}
		
		drawCubes();
		return null;
	}
	
	
	
}
