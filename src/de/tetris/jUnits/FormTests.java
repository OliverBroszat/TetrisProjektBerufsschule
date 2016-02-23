package de.tetris.jUnits;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

import org.junit.Test;

import de.tetris.steuerungsschicht.Block;
import de.tetris.steuerungsschicht.Form;
import de.tetris.steuerungsschicht.FormNormalMode;

public class FormTests {

	@Test
	public void hatJedeFormVierBloecke() {

		Form form = new FormNormalMode();

		for (int i = 0; i < form.getBlockList().size(); i++) {
			assertFalse(form.getBlockList().get(i).equals(null));
		}

	}

//	@Test
//	public void istJedeFormVorhanden() {
//
////		Form form = new FormNormalMode();
//
//		ArrayList<List<Block>> formen = new ArrayList<List<Block>>();
//
//		// List<Block> bloecke = form.getBlockList();
//		//
//		// formen.add(bloecke);
//
//		for (int i = 0; i < 30; i++) {
//			Form form = new FormNormalMode();
//			List<Block> neueBloecke = form.getBlockList();
//			ArrayList<Boolean> booleanList = new ArrayList<Boolean>();
//
//			if (formen.isEmpty()) {
//				formen.add(neueBloecke);
//			} else {
//				for (int j = 0; j < formen.size(); j++) {
//
//					List<Block> listenBloecke = formen.get(j);
//					boolean blockFound = vergleicheFormen(neueBloecke, listenBloecke);
//					
//					booleanList.add(blockFound);
//
//					
//					// for (int k = 0; k < bloecke.size(); k++) {
//					// if (!bloecke.get(k).equals(formen.get(j).get(k))) {
//					// k = bloecke.size();
//					// blockFound = false;
//					// }
//					// }
//					// if (blockFound) {
//					// formen.add(bloecke);
//					// }
//				}
//				if (!booleanList.contains(true)){
//					formen.add(neueBloecke);
//				}
//			}
//		}
//		assertTrue(7 == formen.size());
//		//
//		//
//		// assertFalse(form.getStartBlock().equals(null));
//		// assertFalse(form.getBlock2().equals(null));
//		// assertFalse(form.getBlock3().equals(null));
//		// assertFalse(form.getBlock4().equals(null));
//
//	}
//
//	public boolean vergleicheFormen(List<Block> neueBloecke,
//			List<Block> listenBloecke) {
//		boolean blockFound = true;
//
//		for (int i = 0; i < neueBloecke.size(); i++) {
//			if (!neueBloecke.get(i).equals(listenBloecke.get(i))) {
//				i = neueBloecke.size();
//				blockFound = false;
//			}
//
//		}
//		return blockFound;
//
//	}

}
