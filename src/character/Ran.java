package character;

import main.Main;

public class Ran extends CharacterWithAbility {

	public Ran(int indexX, int indexY, boolean isLight) {
		super(indexX, indexY, isLight, 3);

	}

	public void ability() {
		Main.itemChosen.movable();

	}
}
