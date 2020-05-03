package character;

import main.Main;

public class Kogoro extends CharacterWithAbility {

	public Kogoro(int indexX, int indexY, boolean isLight) {
		super(indexX, indexY, isLight, 3);
	}

	public void ability() {
		Main.itemChosen.movable();
	}

}
