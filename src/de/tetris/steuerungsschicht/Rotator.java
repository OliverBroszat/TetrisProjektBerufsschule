package de.tetris.steuerungsschicht;

public class Rotator implements Rotatable{

	private int rotateCount = 0;
	
	public int getRotateCount() {
		return rotateCount;
	}
	
	public void setRotateCount(int rotateCount) {
		this.rotateCount = rotateCount;
	}
	
	public void starteRotieren(Block startBlock)
	{
		rotateCount = 0;
		rotieren(startBlock);
	}
	
	protected void rotieren(Block startBlock)
	{
		if(rotateCount < 3)
		{
			if(startBlock.getNachbarRechts() != null)
			{
				startBlock.setNachbarUnten(startBlock.getNachbarRechts());
				rotateCount = rotateCount + 1;
				rotieren(startBlock.getNachbarUnten());
			}
			if(startBlock.getNachbarUnten() != null)
			{
				startBlock.setNachbarLinks(startBlock.getNachbarUnten());
				rotateCount = rotateCount + 1;
				rotieren(startBlock.getNachbarLinks());
			}
			if(startBlock.getNachbarLinks() != null)
			{
				startBlock.setNachbarOben(startBlock.getNachbarLinks());
				rotateCount = rotateCount + 1;
				rotieren(startBlock.getNachbarOben());
			}
			if(startBlock.getNachbarOben() != null)
			{
				startBlock.setNachbarRechts(startBlock.getNachbarOben());
				rotateCount = rotateCount + 1;
				rotieren(startBlock.getNachbarRechts());
			}
		}
	}
}
