package character;

import java.util.Random;
import main.Main;

public class Conan extends CharacterWithAbility {
	public static int choice;

	public Conan(int indexX, int indexY, boolean isLight) {
		super(indexX, indexY, isLight, 3);

	}

	public void ability() {

		while (true) {
			Random rand = new Random();
			int i = rand.nextInt(8);
			if (!Main.indexToCha(i).getIsMrJack()) {
				if (Main.indexToCha(i).getIsChoice()) {
					Main.indexToCha(i).setIsChoice(false);
					System.out.println(i + " removed from choice");
					choice = i;
					break;
				}
			}

		}

	}

}
