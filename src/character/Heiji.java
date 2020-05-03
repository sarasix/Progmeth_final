package character;

import main.Main;

public class Heiji extends CharacterWithAbility {

	public Heiji(int indexX, int indexY, boolean isLight) {
		super(indexX, indexY, isLight, 3);

	}

	public void ability() {
		Main.itemChosen.movable();

	}

}
