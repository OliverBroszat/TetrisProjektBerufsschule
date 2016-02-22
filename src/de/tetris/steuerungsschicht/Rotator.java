package de.tetris.steuerungsschicht;

public class Rotator implements Rotatable{

	private int rotateCount = 0;
	private Form copyForm = new FormNormalMode();
	
	public int getRotateCount() {
		return rotateCount;
	}
	
	public void setRotateCount(int rotateCount) {
		this.rotateCount = rotateCount;
	}
	
	public Form starteRotieren(Form formToRotate)
	{
		rotateCount = 0;
		this.copyForm.emptyList();
		rotieren(formToRotate.blockList.get(0));
		return this.copyForm;
	}
	
	private void rotieren(Block currBlock)
	{
			if(currBlock.getNachbarRechts() != null)
			{
				Block nextBlock;
				System.out.println("rotate right");
				if(currBlock.getNachbarUnten() == null){
					System.out.println("unten is null");
					nextBlock = currBlock.getNachbarRechts();
					currBlock.setNachbarRechts(null);
					currBlock.setNachbarUnten(nextBlock);
				}else{
					rotateCount = rotateCount + 1;
					System.out.println("add: one block");
					copyForm.blockList.add(currBlock.getNachbarUnten());
					rotieren(currBlock.getNachbarUnten());
				}
				rotateCount = rotateCount + 1;
			}
			
			if(currBlock.getNachbarLinks() != null)
			{
				Block nextBlock;
				System.out.println("rotate left");
				if(currBlock.getNachbarOben() == null){
					System.out.println("oben is null");
					nextBlock = currBlock.getNachbarLinks();
					currBlock.setNachbarLinks(null);
					currBlock.setNachbarOben(nextBlock);
				}else{
					rotateCount = rotateCount + 1;
					System.out.println("add: one block");
					copyForm.blockList.add(currBlock.getNachbarOben());
					rotieren(currBlock.getNachbarOben());	
				}
			}
			
			if(currBlock.getNachbarUnten() != null)
			{
				Block nextBlock;
				System.out.println("rotate left");
				if(currBlock.getNachbarLinks() == null){
					nextBlock = currBlock.getNachbarUnten();
					currBlock.setNachbarUnten(null);
					currBlock.setNachbarLinks(nextBlock);
				}else{
					rotateCount = rotateCount + 1;
					System.out.println("add: one block");
					copyForm.blockList.add(currBlock.getNachbarLinks());
					rotieren(currBlock.getNachbarLinks());
				}
			}
			
			if(currBlock.getNachbarOben() != null)
			{
				Block nextBlock;
				System.out.println("rotate left");
				if(currBlock.getNachbarRechts() == null){
					nextBlock = currBlock.getNachbarOben();
					currBlock.setNachbarOben(null);
					currBlock.setNachbarRechts(nextBlock);
				}else{
					rotateCount = rotateCount + 1;
					System.out.println("add: one block");
					copyForm.blockList.add(currBlock.getNachbarRechts());
					rotieren(currBlock.getNachbarRechts());
				}
			}
		System.out.println("FORM SIZE: " + copyForm.blockList.size());
	}
}
