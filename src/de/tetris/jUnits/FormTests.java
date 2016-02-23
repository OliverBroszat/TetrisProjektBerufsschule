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

	@Test
	public void istJedeFormVorhanden() {

		ArrayList<List<Block>> formen = new ArrayList<List<Block>>();

		for (int i = 0; i < 30; i++) {
			Form form = new FormNormalMode();
			List<Block> neueBloecke = form.getBlockList();
			ArrayList<Boolean> booleanList = new ArrayList<Boolean>();

			if (formen.isEmpty()) {
				formen.add(neueBloecke);
			} else {
				for (int j = 0; j < formen.size(); j++) {
					List<Block> listenBloecke = formen.get(j);
					boolean blockFound = vergleicheFormen(neueBloecke, listenBloecke);
					booleanList.add(blockFound);
				}
				if (!booleanList.contains(true)) {
					formen.add(neueBloecke);
				}
			}
		}
		assertTrue(7 == formen.size());
	
	}

	public boolean vergleicheFormen(List<Block> neueBloecke, List<Block> listenBloecke) {
		boolean blockFound = false;

		for (int i = 0; i < neueBloecke.size(); i++) {
			blockFound= false;
			if (neueBloecke.get(i).getNachbarLinks() == null && listenBloecke.get(i).getNachbarLinks() == null
					|| neueBloecke.get(i).getNachbarLinks() != null && listenBloecke.get(i).getNachbarLinks() != null) {

				if (neueBloecke.get(i).getNachbarOben() == null && listenBloecke.get(i).getNachbarOben() == null
						|| neueBloecke.get(i).getNachbarOben() != null
								&& listenBloecke.get(i).getNachbarOben() != null) {
						if (neueBloecke.get(i).getNachbarRechts() == null
								&& listenBloecke.get(i).getNachbarRechts() == null
								|| neueBloecke.get(i).getNachbarRechts() != null
										&& listenBloecke.get(i).getNachbarRechts() != null) {
							if (neueBloecke.get(i).getNachbarUnten() == null
									&& listenBloecke.get(i).getNachbarUnten() == null
									|| neueBloecke.get(i).getNachbarUnten() != null
											&& listenBloecke.get(i).getNachbarUnten() != null)
								blockFound = true;
						
					}
				}

			}

			if (!blockFound) {
				i = neueBloecke.size();
			}

		}
		return blockFound;

	}

}
