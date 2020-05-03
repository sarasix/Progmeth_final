package character;

import main.Main;
import map.Map;
import view.GamePlay;

public class ShadowMan extends CharacterWithAbility {

	public ShadowMan(int indexX, int indexY, boolean isLight) {
		super(indexX, indexY, isLight, 3);

	}

	public void ability() {

		int indexXOther = Main.indexToCha(GamePlay.cha).getIndexX();
		int indexYOther = Main.indexToCha(GamePlay.cha).getIndexY();

		Main.indexToCha(GamePlay.cha).setIndexX(this.getIndexX());
		Main.indexToCha(GamePlay.cha).setIndexY(this.getIndexY());

		GamePlay.indexToIVBoard(GamePlay.cha).setX(148 + 66 * this.getIndexY());
		GamePlay.indexToIVBoard(GamePlay.cha).setY(100 + 66 * this.getIndexX());

		Map.m2[Main.indexToCha(GamePlay.cha).getIndexX()][Main.indexToCha(GamePlay.cha).getIndexY()] = Main
				.indexToCha(GamePlay.cha);
		Map.m2[this.getIndexX()][this.getIndexY()] = this;

		this.setIndexX(indexXOther);
		this.setIndexY(indexYOther);

		GamePlay.indexToIVBoard(GamePlay.abi).setX(148 + 66 * indexYOther);
		GamePlay.indexToIVBoard(GamePlay.abi).setY(100 + 66 * indexXOther);

		if (GamePlay.cha == 6) {
			GamePlay.lightHaibara.setX(140 + 66 * Main.indexToCha(GamePlay.cha).getIndexY());
			GamePlay.lightHaibara.setY(90 + 66 * Main.indexToCha(GamePlay.cha).getIndexX());
		}

	}
}
