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
		this.copyForm.blockList.add(formToRotate.blockList.get(0));
		rotieren(formToRotate.blockList.get(0));
		return this.copyForm;
	}
	
	private void rotieren(Block currBlock)
	{
			if(currBlock.getNachbarLinks() != null){
				
			}
			if(currBlock.getNachbarRechts() != null){
							
			}
			if(currBlock.getNachbarUnten() != null){
				
			}
			if(currBlock.getNachbarOben() != null){
				
			}
	}
}
