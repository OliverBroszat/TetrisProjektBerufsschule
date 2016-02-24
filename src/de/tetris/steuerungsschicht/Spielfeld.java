package de.tetris.steuerungsschicht;

import java.io.Serializable;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.util.CollisionCheckStack;

public class Spielfeld implements Serializable {
	private static final int FIELD_WIDTH = 20;
	private static final int FIELD_HEIGHT = 12;
	private Block[][] cubes = new Block[FIELD_WIDTH][FIELD_HEIGHT];
	private ArrayList<Form> formList = new ArrayList<Form>();
	private static final int START_Y = 1;
	private static final int START_X = 5;
	private Serializer basicSerializer = new BasicSerializer();

	private boolean borderCollisionLeft = false;
	private boolean borderCollisionRight = false;
	private boolean borderCollisionUp = false;
	private boolean borderCollisionDown = false;

	private boolean blockCollsionLeft = false;
	private boolean blockCollsionRight = false;
	private boolean blockCollsionDown = false;

	private Rotator rotator;
	private Block centerBlock = null;

	private int blockStartX = START_X;
	private int blockStartY = START_Y;
	private int offsetY;
	private int offsetX;
	private Form rotatedForm = null;

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

	public int getBlockStartX() {
		return blockStartX;
	}

	public void setBlockStartX(int startX) {
		this.blockStartX = startX;
	}

	public int getBlockStartY() {
		return blockStartY;
	}

	public void setBlockStartY(int startY) {
		this.blockStartY = startY;
	}

	public Block[][] getCubes() {
		return cubes;
	}

	public void setCubes(Block[][] cubes) {
		this.cubes = cubes;
	}

	public Spielfeld() {
		this.rotator = new Rotator();
	}

	public void startSpiel() {
		this.clearAllCubes();
		this.centerBlock = null;
		this.spawnBlock();
	}

	// Löscht alle Blöcke aus dem Spielfeld
	private void clearAllCubes() {
		for (int i = 0; i < cubes.length; i++) {
			for (int j = 0; j < cubes[0].length; j++) {
				cubes[i][j] = null;
			}
		}
	}

	public void spawnBlock() {
		System.out.println(" SPAWN BLOCK ");
		this.rotatedForm = null;
		this.rotatedForm = new FormNormalMode();
		this.centerBlock = rotatedForm.blockList.get(0);

		this.setBlockStartX(this.START_X);
		this.setBlockStartY(this.START_Y);

		this.cubes[this.getBlockStartY()][this.getBlockStartX()] = this.centerBlock;
		this.move("down");
	}

	// testmethode not in use
	public void initNormalMode() {
		this.move("down");
		// this.rotate();
		this.drawCubes(offsetY, offsetX);
	}

	public void rotate() {
		this.checkBorderCollision(this.centerBlock, offsetY, offsetX);
		// if(!borderCollisionDown || !borderCollisionLeft ||
		// !borderCollisionRight || !borderCollisionUp){
		// this.checkBlockCollision(centerBlock, offsetY, offsetX);
		// if(!blockCollsionDown || !blockCollsionLeft || !blockCollsionRight){
		this.delete();
		rotatedForm = this.rotator.starteRotieren(rotatedForm);
		this.centerBlock = rotatedForm.blockList.get(0);
		System.out.println("ROTEDED SIZE: " + rotatedForm.blockList.size());
		this.move();
		// }
	}

	public void move(String direction) {
		borderCollisionLeft = false;
		borderCollisionRight = false;
		borderCollisionUp = false;
		borderCollisionDown = false;

		offsetY = this.getBlockStartY();
		offsetX = this.getBlockStartX();

		this.checkBorderCollision(this.centerBlock, offsetY, offsetX);

		switch (direction) {
		case "down":
			if (!borderCollisionDown) {

				// this.checkBlockCollision(this.centerBlock, offsetY, offsetX);
				// if(!blockCollsionDown){
				this.delete();
				this.offsetY++;
				this.move();
				// }
			} else {
				this.spawnBlock();
			}
			break;
		case "right":
			if (!borderCollisionRight) {
				// this.checkBlockCollision(this.centerBlock, offsetY, offsetX);
				// if(!blockCollsionRight){
				this.delete();
				this.offsetX++;
				this.move();
				// }
			} else {

			}
			break;
		case "left":
			if (!borderCollisionLeft) {
				// this.checkBlockCollision(this.centerBlock, offsetY, offsetX);
				// if(!blockCollsionLeft){
				this.delete();
				this.offsetX--;
				this.move();
				// }
			}
			break;
		case "up":
			if (!borderCollisionUp) {
				this.delete();
				this.offsetY--;
				this.move();
			}
			break;
		default:
			break;
		}
	}

	private void delete() {
		System.out.println("DELETE");
		this.deleteMovingBlocks(this.centerBlock, this.offsetY, this.offsetX);
		this.cubes[this.offsetY][this.offsetX] = null;
	}

	private void move() {
		System.out.println("SET!");
		this.cubes[offsetY][offsetX] = this.centerBlock;
		this.setMovingBlocks(this.centerBlock, offsetY, offsetX);
		this.setBlockStartX(offsetX);
		this.setBlockStartY(offsetY);
	}

	// Testmethode not in use
	public void drawCubes(int offsetY, int offsetX) {
		int rows = cubes.length;
		int cols = cubes[0].length;

		for (int i = 0; i < rows; i++) {
			System.out.println("");
			for (int j = 0; j < cols; j++) {
				if (cubes[i][j] != null) {
					System.out.print("X");
				} else {
					System.out.print("0");
				}
			}
		}

		System.out.println();
		System.out.println();
		System.out.println();
	}

	public boolean isOutOfBounce(int curY, int curX) {
		int rows = cubes.length;
		int cols = cubes[0].length;
		boolean status = false;

		if (curY > (rows - 1)) {
			System.out.println("Unten Rand! ");
			status = true;
		}

		if (curX >= cols) {
			System.out.println("Rechts Rand! ");
			status = true;
		}

		if (curX < 0) {
			System.out.println("Linker Rand! ");
			status = true;
		}

		if (curY < 0) {
			System.out.println("Oben Rand! ");
			status = true;
		}

		return status;
	}

	private void checkBlockCollision(Block currBlock, int curY, int curX) {
		// check ob der nächste cube leer ist
		if (cubes[curY][curX - 1] != null) {
			System.out.println("block collision LEFT");
			blockCollsionLeft = true;
		} else {
			if (currBlock.getNachbarLinks() != null) {
				this.checkBlockCollision(currBlock.getNachbarLinks(), curY, curX - 1);
			}
		}
		// check ob der nächste cube leer ist
		if (cubes[curY][curX + 1] != null) {
			System.out.println("block collision RIGHT");
			blockCollsionRight = true;
		} else {
			if (currBlock.getNachbarRechts() != null) {
				this.checkBlockCollision(currBlock.getNachbarRechts(), curY, curX + 1);
			}
		}

		// check ob der nächste cube leer ist
		if (cubes[curY + 1][curX] != null) {
			System.out.println("block collision DOWN");
			blockCollsionDown = true;
		} else {
			if (currBlock.getNachbarUnten() != null) {
				this.checkBorderCollision(currBlock.getNachbarUnten(), curY + 1, curX);
			}
		}
	}

	private void checkBorderCollision(Block currBlock, int curY, int curX) {
		if (this.isOutOfBounce(curY, curX - 1)) {
			System.out.println("check block links");
			borderCollisionLeft = true;
		} else {
			if (currBlock.getNachbarLinks() != null) {
				this.checkBorderCollision(currBlock.getNachbarLinks(), curY, curX - 1);
			}
		}

		if (this.isOutOfBounce(curY, curX + 1)) {
			System.out.println("check block Rechts");
			borderCollisionRight = true;
		} else {
			if (currBlock.getNachbarRechts() != null) {
				this.checkBorderCollision(currBlock.getNachbarRechts(), curY, curX + 1);
			}
		}

		if (this.isOutOfBounce(curY - 1, curX)) {
			System.out.println("check block Oben");
			borderCollisionUp = true;
		} else {
			if (currBlock.getNachbarOben() != null) {
				this.checkBorderCollision(currBlock.getNachbarOben(), curY - 1, curX);
			}
		}

		if (this.isOutOfBounce(curY + 1, curX)) {
			System.out.println("check block Unten");
			this.centerBlock = null;
			borderCollisionDown = true;
		} else {
			if (currBlock.getNachbarUnten() != null) {
				this.checkBorderCollision(currBlock.getNachbarUnten(), curY + 1, curX);
			}
		}
	}

	private Block setMovingBlocks(Block currBlock, int curY, int curX) {
		int x = curX;
		int y = curY;

		if (currBlock.getNachbarLinks() != null) {
			// System.out.println("Setze block links");

			if (cubes[y][x - 1] == null) {
				cubes[y][x - 1] = currBlock.getNachbarLinks();
				this.setMovingBlocks(currBlock.getNachbarLinks(), y, x - 1);
			}
		}

		if (currBlock.getNachbarRechts() != null) {
			// System.out.println("Setze block Rechts");
			if (cubes[y][x + 1] == null) {
				cubes[y][x + 1] = currBlock.getNachbarRechts();
				this.setMovingBlocks(currBlock.getNachbarRechts(), y, x + 1);
			}
		}

		if (currBlock.getNachbarOben() != null) {
			// System.out.println("Setze block Oben");
			if (cubes[y - 1][x] == null) {
				cubes[y - 1][x] = currBlock.getNachbarOben();
				this.setMovingBlocks(currBlock.getNachbarOben(), y - 1, x);
			}
		}

		if (currBlock.getNachbarUnten() != null) {
			// System.out.println("Setze block Unten");
			if (cubes[y + 1][x] == null) {
				cubes[y + 1][x] = currBlock.getNachbarUnten();
				this.setMovingBlocks(currBlock.getNachbarUnten(), y + 1, x);
			}
		}

		// System.out.println("STACK ENDE");
		return null;
	}

	private Block deleteMovingBlocks(Block currBlock, int curY, int curX) {
		int x = curX;
		int y = curY;

		if (currBlock.getNachbarLinks() != null) {
			if (cubes[y][x - 1] != null) {
				this.deleteMovingBlocks(currBlock.getNachbarLinks(), y, x - 1);
				cubes[y][x - 1] = null;
			}
		}

		if (currBlock.getNachbarRechts() != null) {
			if (cubes[y][x + 1] != null) {
				this.deleteMovingBlocks(currBlock.getNachbarRechts(), y, x + 1);
				cubes[y][x + 1] = null;
			}
		}

		if (currBlock.getNachbarOben() != null) {
			if (cubes[y - 1][x] != null) {
				this.deleteMovingBlocks(currBlock.getNachbarOben(), y - 1, x);
				cubes[y - 1][x] = null;
			}
		}

		if (currBlock.getNachbarUnten() != null) {
			if (cubes[y + 1][x] != null) {
				this.deleteMovingBlocks(currBlock.getNachbarUnten(), y + 1, x);
				cubes[y + 1][x] = null;
			}
		}

		// System.out.println("STACK ENDE");
		return null;
	}

	public void rewriteCubes(Block[][] tmp) {
		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp[i].length; j++) {
				cubes[i][j] = tmp[i][j];
			}
		}
	}

	public void serialize() {
		delete();
		basicSerializer.serialize(cubes);
	}

	public void deSerialize() {
		rewriteCubes(basicSerializer.deSerialize());
	}
}
