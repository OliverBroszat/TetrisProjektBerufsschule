package de.tetris.steuerungsschicht;

public class FormNormalMode extends Form{
	
	@Override
	public void formeBlock() {
			Block startBlock = new Block();
			Block block2 = new Block();
			Block block3 = new Block();
			Block block4 = new Block();
			blockList.add(startBlock);
			blockList.add(block2);
			blockList.add(block3);
			blockList.add(block4);
			int zufall =  2; //(int)((Math.random()*7)+1);
			switch (zufall) {
			case 1	:	startBlock.setNachbarRechts(block2);
						block2.setNachbarRechts(block3);
						block3.setNachbarRechts(block4);
						break;
			case 2	:	startBlock.setNachbarRechts(block2);
						startBlock.setNachbarLinks(block3);
						block3.setNachbarOben(block4);
						break;
			case 3	:	startBlock.setNachbarRechts(block2);
						block2.setNachbarOben(block3);
						startBlock.setNachbarLinks(block4);
						break;
			case 4	:	startBlock.setNachbarRechts(block2);
						block2.setNachbarUnten(block3);
						block3.setNachbarLinks(block4);
						break;
			case 5	:	startBlock.setNachbarRechts(block2);
						startBlock.setNachbarUnten(block3);
						block3.setNachbarLinks(block4);
						break;
			case 6	:	startBlock.setNachbarLinks(block2);
						startBlock.setNachbarUnten(block3);
						block3.setNachbarRechts(block4);
						break;
			case 7	:	startBlock.setNachbarRechts(block2);
						startBlock.setNachbarLinks(block3);
						startBlock.setNachbarOben(block4);
						break;
			}
		
	}

}
