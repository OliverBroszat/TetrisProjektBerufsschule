package de.tetris.steuerungsschicht;

public class Rotator implements Rotatable{

	private int rotateCount = 0;
	private Form copyForm = null;
	
	public int getRotateCount() {
		return rotateCount;
	}
	
	public void setRotateCount(int rotateCount) {
		this.rotateCount = rotateCount;
	}
	
	public Form starteRotieren(Form formToRotate)
	{
		copyForm = new FormNormalMode();
		copyForm.emptyList();
		rotateCount = 0;
		Block startBlock = formToRotate.blockList.get(0);
		Block targetStartBlock = new Block();
		rotieren(startBlock, targetStartBlock, targetStartBlock);
		return copyForm;
	}
	
	private void rotieren(Block currBlock, Block targetBlock, Block targetBlockParent)
	{
		if(rotateCount == 0){
			copyForm.blockList.add(targetBlock);
		}
		
		if(rotateCount <= 3){
			if(currBlock.getNachbarLinks() != null)
			{
				Block tempBlock = new Block();
				targetBlock.setNachbarOben(tempBlock);
				copyForm.blockList.add(tempBlock);	
				System.out.println("ADDED BLOCK OBEN");
				rotateCount++;
				
				// richtig Original  | richtig copie | parent copie
				rotieren(currBlock.getNachbarLinks(), targetBlock.getNachbarOben(), targetBlock);					
			}
	
			if(currBlock.getNachbarUnten() != null)
			{
				Block tempBlock = new Block();
				targetBlock.setNachbarLinks(tempBlock);
				copyForm.blockList.add(tempBlock);
				System.out.println("ADDED BLOCK LINKS");
				rotateCount++;
				
				// richtig Original  | richtig copie | parent copie
				rotieren(currBlock.getNachbarUnten(), targetBlock.getNachbarLinks(), targetBlock);					
			}
			
			if(currBlock.getNachbarRechts() != null)
			{
				Block tempBlock = new Block();
				targetBlock.setNachbarUnten(tempBlock);
				copyForm.blockList.add(tempBlock);
				System.out.println("ADDED BLOCK UNTEN");
				rotateCount++;
				
				// richtig Original  | richtig copie | parent copie
				rotieren(currBlock.getNachbarRechts(), targetBlock.getNachbarUnten(), targetBlock);								
			}
			
			if(currBlock.getNachbarOben() != null)
			{
				Block tempBlock = new Block();
				targetBlock.setNachbarRechts(tempBlock);
				copyForm.blockList.add(tempBlock);
				System.out.println("ADDED BLOCK RECHTS");
				rotateCount++;
				
				// richtig Original  | richtig copie | parent copie
				rotieren(currBlock.getNachbarOben(), targetBlock.getNachbarRechts(), targetBlock);					
			}
		}
	}
}
