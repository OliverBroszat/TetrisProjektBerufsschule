package de.tetris.steuerungsschicht;

import java.util.ArrayList;

public class Spielfeld {
	private static final int FIELD_WIDTH = 24;
	private static final int FIELD_HEIGHT = FIELD_WIDTH / 2;
	private Block[][] cubes = new Block[FIELD_WIDTH][FIELD_HEIGHT];
	private ArrayList<Form> formList = new ArrayList<Form>();
	private static final int START_X = 4;
	private static final int START_Y = 3;
	
	private Block centerBlock = null;
	
	private int moveSpeed = 1;
	private int startX = 0;
	private int startY = 0;
	
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

	private Rotator rotator;

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

		
		this.move("down");
		//this.move("down");
	}
	
	public void move(String direction){
		switch(direction){
		case "down": 
//				clearAllCubes();
//
//				int offsetY = this.getStartY();
//				int offsetX = this.getStartX();
//				
//				this.cubes[offsetY][offsetX] = this.centerBlock;
//				if(!checkCollision(this.centerBlock, offsetY, offsetX)){
//					offsetY += moveSpeed;
//					
//					this.setMovingBlocks(this.centerBlock, offsetY, offsetX);
//					this.setStartX(offsetY);
//					this.setStartY(offsetX);
//					this.drawCubes(offsetY, offsetX);
//				};
				
				clearAllCubes();

				int offsetY = this.getStartY() + moveSpeed;;
				int offsetX = this.getStartX();
				
				if(!checkCollision(this.centerBlock, offsetY, offsetX)){
					System.out.println("COLLISION!!");
				}
				
				this.cubes[offsetY][offsetX] = this.centerBlock;
				this.setMovingBlocks(this.centerBlock, offsetY, offsetX);
					this.setStartX(offsetY);
					this.setStartY(offsetX);
					this.drawCubes(offsetY, offsetX);				
			break;
		case "right":
			 //Form newBlock = this.rotator.starteRotieren(this.centerBlock);
			 //this.centerBlock = newBlock.blockList.get(0);
			 //this.setMovingBlocks(this.centerBlock, curY, curX)
			 
			 break;
		default: break;
		}
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
	}
	
	public boolean isOutOfBounce(int curY, int curX){
		int rows = cubes.length;
		int cols = cubes[0].length;
		boolean status = false;
		
		if(curX > rows){
			System.out.println("Unten Rand! ");
			status = true;
		}
	
		if(curY > cols){
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
	
	private boolean checkCollision(Block currBlock, int curY, int curX){	
		int x = curX;
		int y = curY;
		boolean status = false;
		
		if(currBlock.getNachbarLinks() != null){
			//System.out.println("Setze block links");
			if(!this.isOutOfBounce(curY, curX - 1)){
				this.checkCollision(currBlock.getNachbarLinks(), curY, curX);
			}else{
				status = true;
			}
		}
		
		if(currBlock.getNachbarRechts() != null){
			//System.out.println("Setze block Rechts");
			if(!this.isOutOfBounce(curY, curX + 1)){
				this.checkCollision(currBlock.getNachbarRechts(), curY, curX);
			}else{
				status = true;
			}
		}
		
		if(currBlock.getNachbarOben() != null){
			//System.out.println("Setze block Oben");
			if(!this.isOutOfBounce(curY - 1, curX)){
				this.checkCollision(currBlock.getNachbarOben(), curY, curX);
			}else{
				status = true;
			}
		}
		
		if(currBlock.getNachbarUnten() != null){
			//System.out.println("Setze block Unten");
			if(!this.isOutOfBounce(curY + 1, curX)){
				this.checkCollision(currBlock.getNachbarUnten(), curY, curX);
			}else{
				status = true;
			}
		}
		
		//System.out.println("STACK ENDE");
		return status;
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
