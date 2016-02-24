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
		rotieren(formToRotate.blockList.get(0), formToRotate.blockList.get(0));
		return formToRotate;
	}
	
	private int rotieren(Block currBlock, Block parent)
	{
		
			if(currBlock.getNachbarLinks() != null){
				System.out.print(" LINKS -> ");
				rotieren(currBlock.getNachbarLinks(), currBlock);
			}
			if(currBlock.getNachbarUnten() != null){
				System.out.print(" UNTEN -> ");
				rotieren(currBlock.getNachbarUnten(), currBlock);
			}
			if(currBlock.getNachbarRechts() != null){
				System.out.print(" RECHTS -> ");
				rotieren(currBlock.getNachbarRechts(), currBlock);
			}
			
			if(currBlock.getNachbarOben() != null){
				System.out.print(" OBEN -> ");
				rotieren(currBlock.getNachbarOben(), currBlock);
			}
			
			if(rotateCount < 3){
				if(parent.getNachbarOben() == null){
					System.out.println("Parent setze Block Oben ");
					parent.setNachbarOben(currBlock);
					parent.setNachbarLinks(null);
					rotateCount++;
					return 0;
				}
		
				if(parent.getNachbarRechts() == null){
					System.out.println("Parent setze Block Rechts ");
					parent.setNachbarRechts(currBlock);
					parent.setNachbarOben(null);
					rotateCount++;
					return 0;
				}
				
				if(parent.getNachbarUnten() == null){
					System.out.println("Parent setze Block Unten");
					parent.setNachbarUnten(currBlock);
					parent.setNachbarRechts(null);
					rotateCount++;
					return 0;
				}
				
				if(parent.getNachbarLinks() == null){
					System.out.println("Parent setze Block Links ");
					parent.setNachbarLinks(currBlock);
					parent.setNachbarUnten(null);
					rotateCount++;
					return 0;
				}
			}
			
			return 0;
	}
}
