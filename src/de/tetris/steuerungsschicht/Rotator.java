package de.tetris.steuerungsschicht;

public class Rotator implements Rotatable{

	private int rotateCount = 0;
	
	public int getRotateCount() {
		return rotateCount;
	}
	
	public void setRotateCount(int rotateCount) {
		this.rotateCount = rotateCount;
	}
	
	public Form starteRotieren(Form formToRotate)
	{
		rotateCount = 0;
		Form newForm = new FormNormalMode();
		newForm.emptyList();
		newForm = rotieren(newForm, formToRotate.blockList.get(0));
		return newForm;
	}
	
	protected Form rotieren(Form form, Block currBlock)
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
					form.blockList.add(currBlock.getNachbarUnten());
					form = rotieren(form, currBlock.getNachbarUnten());
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
					form.blockList.add(currBlock.getNachbarOben());
					form = rotieren(form, currBlock.getNachbarOben());
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
					form.blockList.add(currBlock.getNachbarLinks());
					form = rotieren(form, currBlock.getNachbarLinks());
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
					form.blockList.add(currBlock.getNachbarRechts());
					form = rotieren(form, currBlock.getNachbarRechts());
				}
			}
		System.out.println("FORM SIZE: " + form.blockList.size());
		return form;
	}
}
