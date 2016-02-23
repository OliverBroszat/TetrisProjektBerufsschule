package de.tetris.steuerungsschicht;

import java.util.ArrayList;

public class Spielfeld {
	private static final int FIELD_WIDTH = 24;
	private static final int FIELD_HEIGHT = FIELD_WIDTH / 2;
	private Block[][] cubes = new Block[FIELD_WIDTH][FIELD_HEIGHT];
	private ArrayList<Form> formList = new ArrayList<Form>();
	private static final int START_X = 4;
	private static final int START_Y = 3;
	
	private boolean borderCollisionLeft = false;
	private boolean borderCollisionRight = false;
	private boolean borderCollisionUp = false;
	private boolean borderCollisionDown = false;

	private Rotator rotator;
	private Block centerBlock = null;

	private int startX = START_X;
	private int startY = START_Y;
	private int offsetY;
	private int offsetX;
	
	public int getOffsetY() {
		return offsetY;
	}

	public void setOffsetY(int offsetY) {
		this.offsetY = offsetY;
	}

	public int getOffsetX() {
		return offsetX;
	}

	public void setOffsetX(int offsetX) {
		this.offsetX = offsetX;
	}
	
	public int getStartX() {
		return startX;
	}

	public void setStartX(int startX) {
		this.startX = startX;
	}

	public int getStartY() {
		return startY;
	}

	public void setStartY(int startY) {
		this.startY = startY;
	}

	public Spielfeld() {
		initNormalMode();
	}

	public void initNormalMode() {
		formList.add(new FormNormalMode());
		
		System.out.println("FORMLIST SIZE:" + this.formList.size());

		this.centerBlock = formList.get(0).blockList.get(0);

		
		this.setStartX(4);
		this.setStartY(3);
		
		this.cubes[this.getStartY()][this.getStartX()] = this.centerBlock;

		
		this.move("right");
		this.move("right");
		this.move("right");
		this.move("right");
		this.move("right");
		this.move("right");
		this.move("right");
		this.move("right");
		this.move("down");
		this.move("down");
		this.move("down");
		this.move("down");
		this.move("down");
		this.move("down");
		this.move("down");
		this.move("down");
		this.move("down");
		this.move("down");
		this.move("down");
		this.move("down");
		this.move("down");
		this.move("down");
		this.move("down");
		this.move("down");
		this.move("down");
		this.move("down");
		this.move("down");
		this.move("down");
		this.move("down");
		this.move("down");
		this.move("down");
		this.move("down");
		this.move("down");
		this.move("down");
		this.move("down");
		this.move("down");
		this.move("down");
	}
	
	public void move(String direction){
		clearAllCubes();
		
		borderCollisionLeft = false;
		borderCollisionRight = false;
		borderCollisionUp = false;
		borderCollisionDown = false;
	
		offsetY = this.getStartY();
		offsetX = this.getStartX();
	
		this.checkCollision(this.centerBlock, offsetY, offsetX);
		switch(direction){
		case "down": 
				if(!borderCollisionDown){
					this.offsetY++;
					this.move();
				}else{
					System.out.println("COLLISION");
				}
			break;
		case "right":
				if(!borderCollisionRight){
					this.offsetX++;
					this.move();
				}else{
					System.out.println("COLLISION");
				}
			 break;
		case "left":
				if(!borderCollisionLeft){
					this.offsetX--;
					this.move();
				}
			 break;
		case "up":
				if(!borderCollisionUp){
					this.offsetY--;
					this.move();
				}
			 break;
		default: break;
		}
	}
	
	private void move(){
			this.cubes[offsetY][offsetX] = this.centerBlock;
			this.setMovingBlocks(this.centerBlock, offsetY, offsetX);
			this.setStartX(offsetX);
			this.setStartY(offsetY);
			this.drawCubes(offsetY, offsetX);		
	}

	private void clearAllCubes(){
		for (int i = 0; i < cubes.length; i++) {
			for (int j = 0; j < cubes[0].length; j++) {
				if(cubes[i][j] != null){
					cubes[i][j] = null;
				}
			}
		}
	}
	
	public void drawCubes(int offsetY,int offsetX) {
		int rows = cubes.length;
		int cols = cubes[0].length;

		for (int i = 0; i < rows; i++) {
			System.out.println("");
			for (int j = 0; j < cols; j++) {
				if(cubes[i][j] != null){
					System.out.print("X");
				}else {
					System.out.print("0");
				}
			}
		}

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	}
	
	public boolean isOutOfBounce(int curY, int curX){
		int rows = cubes.length;
		int cols = cubes[0].length;
		boolean status = false;
		
		System.out.println("VERGLEICHE Y [" + curY + "] mit [ " + (rows-1) + "]");
		if(curY >= rows - 1){
			System.out.println("Unten Rand! ");
			status = true;
		}
	
		System.out.println("VERGLEICHE X [" + curX + "] mit [ " + (cols - 1) + "]");
		if(curX >= cols - 1){
			System.out.println("Rechts Rand! ");
			status = true;
		}
		
		if(curX < 0){
			System.out.println("Linker Rand! ");
			status = true;
		}
		
		if(curY < 0){
			System.out.println("Oben Rand! ");
			status = true;
		}
		
		return status;
	}
	
	private void checkCollision(Block currBlock, int curY, int curX){	
		if(currBlock.getNachbarLinks() != null){
			System.out.println("check block links");
			if(this.isOutOfBounce(curY, curX - 1)){
				borderCollisionLeft = true;
			}else{
				this.checkCollision(currBlock.getNachbarLinks(), curY, curX - 1);	
			}
		}
		
		if(currBlock.getNachbarRechts() != null){
			System.out.println("check block Rechts");
			if(this.isOutOfBounce(curY, curX + 1)){
				borderCollisionRight = true;
			}else{
				this.checkCollision(currBlock.getNachbarRechts(), curY, curX + 1);
			}
		}
		
		if(currBlock.getNachbarOben() != null){
			System.out.println("check block Oben");
			if(this.isOutOfBounce(curY - 1, curX)){
				borderCollisionUp = true;
			}else{
				this.checkCollision(currBlock.getNachbarOben(), curY - 1, curX);
			}
		}
		
		if(currBlock.getNachbarUnten() != null){
			System.out.println("check block Unten");
			if(this.isOutOfBounce(curY + 1, curX)){
				borderCollisionDown = true;
			}else{
				this.checkCollision(currBlock.getNachbarUnten(), curY + 1, curX);
			}
		}
}
	

	private Block setMovingBlocks(Block currBlock, int curY, int curX){	
			int x = curX;
			int y = curY;
			
			if(currBlock.getNachbarLinks() != null){
				//System.out.println("Setze block links");
				
				if(cubes[y][x - 1] == null){
					cubes[y][x - 1] = currBlock.getNachbarLinks();
					this.setMovingBlocks(currBlock.getNachbarLinks(), y, x - 1);
				}
			}
			
			if(currBlock.getNachbarRechts() != null){
				//System.out.println("Setze block Rechts");
				if(cubes[y][x + 1] == null){
					cubes[y][x + 1] = currBlock.getNachbarRechts();
					this.setMovingBlocks(currBlock.getNachbarRechts(), y, x + 1);
				}
			}
			
			if(currBlock.getNachbarOben() != null){
				//System.out.println("Setze block Oben");
				if(cubes[y - 1][x] == null){
					cubes[y - 1][x] = currBlock.getNachbarOben();
					this.setMovingBlocks(currBlock.getNachbarOben(), y - 1, x);
				}
			}
			
			if(currBlock.getNachbarUnten() != null){
				//System.out.println("Setze block Unten");
				if(cubes[y + 1][x] == null){
					cubes[y + 1][x] = currBlock.getNachbarUnten();
					this.setMovingBlocks(currBlock.getNachbarUnten(), y + 1, x);
				}
			}
			
			//System.out.println("STACK ENDE");
			return null;
	}

}
