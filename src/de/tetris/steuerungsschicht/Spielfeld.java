package de.tetris.steuerungsschicht;

import java.util.ArrayList;

public class Spielfeld {
	private static final int FIELD_WIDTH = 24;
	private static final int FIELD_HEIGHT = FIELD_WIDTH / 2;
	private Block[][] cubes = new Block[FIELD_WIDTH][FIELD_HEIGHT];
	private ArrayList<Form> formList = new ArrayList<Form>();

	private Rotator rotator;

	public Spielfeld() {
		initNormalMode();
	}

	public void initNormalMode() {
		formList.add(new FormNormalMode());

		System.out.println("FORMLIST SIZE:" + this.formList.size());

		Block startBlock = formList.get(0).blockList.get(0);
		cubes[3][4] = startBlock;
		this.setBlocks(startBlock, 3 , 4);
		drawCubes();

	}
	
	public boolean isOutOfBounce(int curY, int curX){
			if(cubes[curY + movementY][curX + movementX])
		
			return false;
	}

	public void drawCubes() {
		int rows = cubes.length;
		int cols = cubes[0].length;
		boolean start = true;

		for (int i = 0; i < rows; i++) {
			System.out.println("");
			for (int j = 0; j < cols; j++) {
				if (cubes[i][j] == cubes[3][4]) {
					System.out.print("S");
					start = false;
				} else if(cubes[i][j] != null){
					System.out.print("X");
				}else {
					System.out.print("0");
				}
			}
		}
	}

	private Block setBlocks(Block currBlock, int curY, int curX){	
		boolean hasLeft = false;
		boolean hasRight = false;
		boolean hasUp = false;
		boolean hasDown = false;
		int x = curX;
		int y = curY;
		int offsetX = 0;
		int offsetY = 0;
		
		System.out.println("X : " + x);
		System.out.println("Y : " + y);
		
		if(currBlock.getNachbarLinks() != null){
			//System.out.println("Hat links!");
			if(cubes[y][x - 1] == null){
				hasLeft = true;
			}
		}
		
		if(currBlock.getNachbarRechts() != null){
			//System.out.println("Hat rechts!");
			if(cubes[y][x + 1] == null){
				hasRight = true;
			}
		}
		
		if(currBlock.getNachbarOben() != null){
			//System.out.println("Hat oben!");
			if(cubes[y + 1][x] == null){
				hasUp = true;
			}
		}
		
		if(currBlock.getNachbarUnten() != null){
			//System.out.println("Hat unten!");
			if(cubes[y - 1][x] == null){
				hasDown = true;
			}
		}
		
		System.out.println(hasLeft);
		System.out.println(hasRight);
		System.out.println(hasUp);
		System.out.println(hasDown);	
		
		if(hasLeft){
			//System.out.println("Setze block links");
			if(cubes[y][x - 1] == null){
				cubes[y][x - 1] = currBlock.getNachbarLinks();
				offsetX++;
				this.setBlocks(currBlock.getNachbarLinks(), y, x - 1);
			}
		}
		
		if(hasRight){
			//System.out.println("Setze block Rechts");
			if(cubes[y][x + 1] == null){
				cubes[y][x + 1] = currBlock.getNachbarRechts();
				offsetX--;
				this.setBlocks(currBlock.getNachbarRechts(), y, x + 1);
			}
		}
		
		if(hasUp){
			//System.out.println("Setze block Oben");
			if(cubes[y - 1][x] == null){
				cubes[y - 1][x] = currBlock.getNachbarOben();
				this.setBlocks(currBlock.getNachbarOben(), y - 1, x);
				offsetY++;
			}
		}
				
		if(hasDown){
			//System.out.println("Setze block Unten");
			if(cubes[y + 1][x] == null){
				cubes[y + 1][x] = currBlock.getNachbarUnten();
				this.setBlocks(currBlock.getNachbarUnten(), y + 1, x);
				offsetY--;
			}
		}
		
		//System.out.println("STACK ENDE");
		return cubes[y + offsetY][x + offsetX];
	}

}

