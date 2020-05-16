package main;

import initial.*;
import item.*;
import javafx.scene.image.ImageView;
import java.util.*;
import character.*;
import character.Character;
import exception.WalkInvalid;
import map.Map;
import resloader.Resloader;
import view.GamePlay;

public class Main {
	public static Initial initial = new Initial();
	public static ArrayList<Integer> choice = initial.getChoice();
	public static ArrayList<String> order1 = initial.getOrder1();
	public static ArrayList<String> order2 = initial.getOrder2();
	public static ArrayList<String> order = new ArrayList<String>();
	public static ArrayList<Character> allCharacter = initial.getAllCharacter();
	public static ArrayList<Character> choiceCharacter = new ArrayList<Character>();
	public static int holeColumn;
	public static int holeRow;
	public static boolean jackEscape = false;
	public static Item itemChosen;
	public static ArrayList<Character> card4 = new ArrayList<Character>();
	public static int[] indexItemField = new int[2];
	public static boolean goToHole = false;
	public static Random rand = new Random();
	private static int randomNumber;
	public static Character MrJack;

	public static void start() {

		randomNumber = rand.nextInt(8);
		MrJack = allCharacter.get(randomNumber);

		GamePlay.createJack(Resloader.seeJack, GamePlay.indexToICard(randomNumber));

		System.out.println("MrJack is " + chaToName(MrJack));
		MrJack.setIsMrJack(true);

	}

	public static void goToHole() {
		if (Map.m2[holeRow][holeColumn] == null) {
			GamePlay.indexToIVBoard(GamePlay.cha).setX(148 + 66 * holeColumn);
			GamePlay.indexToIVBoard(GamePlay.cha).setY(100 + 66 * holeRow);

			if (GamePlay.cha == 6) {
				GamePlay.lightHaibara.setX(140 + 66 * holeColumn);
				GamePlay.lightHaibara.setY(90 + 66 * holeRow);
			}
			int[] h = new int[2];
			h[0] = holeRow;
			h[1] = holeColumn;
			Main.indexToCha(GamePlay.cha).walk(h);

			goToHole = true;
			GamePlay.walk++;
			GamePlay.maxWalkAndGoToHole();
		}
	}

	public static Lamp findLampForTurn(int x) {
		int INDEX = 0;
		for (int i = 0; i < Map.allLamp.size(); i++) {
			if (Map.allLamp.get(i).getNumber() == x) {
				INDEX = i;
				break;
			}
		}
		return Map.allLamp.get(INDEX);
	}

	public static ExitBarricade findExitBarricadeForTurn(int x) {
		int INDEX = 0;
		for (int i = 0; i < Map.allExitBarricade.size(); i++) {
			if (Map.allExitBarricade.get(i).getNumber() == x) {
				INDEX = i;
				break;
			}
		}
		return Map.allExitBarricade.get(INDEX);
	}

	public static HoleCover findHoleCoverForTurn(int x) {
		int INDEX = 0;
		for (int i = 0; i < Map.allHoleCover.size(); i++) {
			if (Map.allHoleCover.get(i).getNumber() == x) {
				INDEX = i;
				break;
			}
		}
		return Map.allHoleCover.get(INDEX);
	}

	public static void removeItem() {
		int numLamp = initial.getLawRemoveItem(GamePlay.round - 1, 0);
		int numExitBarricade = initial.getLawRemoveItem(GamePlay.round - 1, 1);
		int numHoleCover = initial.getLawRemoveItem(GamePlay.round - 1, 2);
		if (Map.allLamp.size() > numLamp) {
			randomNumber = rand.nextInt(Map.allLamp.size());

			ImageView iv = null;
			if (Map.allLamp.get(randomNumber).getNumber() == 0)
				iv = GamePlay.lamp0;
			if (Map.allLamp.get(randomNumber).getNumber() == 1)
				iv = GamePlay.lamp1;
			if (Map.allLamp.get(randomNumber).getNumber() == 2)
				iv = GamePlay.lamp2;
			if (Map.allLamp.get(randomNumber).getNumber() == 3)
				iv = GamePlay.lamp3;
			if (Map.allLamp.get(randomNumber).getNumber() == 4)
				iv = GamePlay.lamp4;
			if (Map.allLamp.get(randomNumber).getNumber() == 5)
				iv = GamePlay.lamp5;
			if (Map.allLamp.get(randomNumber).getNumber() == 6)
				iv = GamePlay.lamp6;
			if (Map.allLamp.get(randomNumber).getNumber() == 7)
				iv = GamePlay.lamp7;

			System.out.println("Lamp remove!!");
			Map.m2[Map.allLamp.get(randomNumber).getIndexX()][Map.allLamp.get(randomNumber).getIndexY()] = null;

			GamePlay.gamePane.getChildren().remove(iv);
			Map.allLamp.remove(randomNumber);
		}

		if (Map.allExitBarricade.size() > numExitBarricade) {
			randomNumber = rand.nextInt(Map.allExitBarricade.size());
			System.out.println("ExitBarricade remove!!");
			Map.m2[Map.allExitBarricade.get(randomNumber).getIndexX()][Map.allExitBarricade.get(randomNumber)
					.getIndexY()] = null;

			ImageView iv = null;
			if (Map.allExitBarricade.get(randomNumber).getNumber() == 0)
				iv = GamePlay.exitBarricade0;
			if (Map.allExitBarricade.get(randomNumber).getNumber() == 1)
				iv = GamePlay.exitBarricade1;
			if (Map.allExitBarricade.get(randomNumber).getNumber() == 2)
				iv = GamePlay.exitBarricade2;

			GamePlay.gamePane.getChildren().remove(iv);
			Map.allExitBarricade.remove(randomNumber);
		}
		if (Map.allHoleCover.size() > numHoleCover) {
			randomNumber = rand.nextInt(Map.allHoleCover.size());
			System.out.println("HoleCover remove!!");
			Map.m2[Map.allHoleCover.get(randomNumber).getIndexX()][Map.allHoleCover.get(randomNumber)
					.getIndexY()] = null;

			ImageView iv = null;
			if (Map.allHoleCover.get(randomNumber).getNumber() == 0)
				iv = GamePlay.holeCover0;
			if (Map.allHoleCover.get(randomNumber).getNumber() == 1)
				iv = GamePlay.holeCover1;
			if (Map.allHoleCover.get(randomNumber).getNumber() == 2)
				iv = GamePlay.holeCover2;
			if (Map.allHoleCover.get(randomNumber).getNumber() == 3)
				iv = GamePlay.holeCover3;
			if (Map.allHoleCover.get(randomNumber).getNumber() == 4)
				iv = GamePlay.holeCover4;

			GamePlay.gamePane.getChildren().remove(iv);
			Map.allHoleCover.remove(randomNumber);
		}

	}

	public static void randomCard() {
		int[] card4Index = new int[4];
		card4 = new ArrayList<Character>();
		for (int i = 0; i < 4; i++) {
			while (true) {
				randomNumber = rand.nextInt(8);
				if (i != 0) {
					if (!card4.contains(allCharacter.get(randomNumber))) {
						break;
					}
				} else {
					break;
				}
			}
			card4Index[i] = randomNumber;
			card4.add(allCharacter.get(randomNumber));
		}
		
		
		GamePlay.round++;
		GamePlay.createCard4(card4Index[0], card4Index[1], card4Index[2], card4Index[3]);
		

	}

	public static boolean validPosition(int[] pos) {
		if (pos[0] >= 0 && pos[0] <= 6 && pos[1] >= 0 && pos[1] <= 12) {
			return true;
		}
		return false;
	}

	public static boolean itemMove() {
		if (Map.m2[indexItemField[0]][indexItemField[1]] == null) {
			((CharacterWithAbility) indexToCha(GamePlay.cha)).ability();
			GamePlay.itemSelected.setX(144 + 66 * indexItemField[1]);
			GamePlay.itemSelected.setY(100 + 66 * indexItemField[0]);
			return true;
		}
		return false;
	}

	public static void walk() throws WalkInvalid {
		
		Character c = indexToCha(GamePlay.cha);
		int[] u = new int[2];
		u[0] = c.getIndexX() + GamePlay.dir1;
		u[1] = c.getIndexY() + GamePlay.dir2;
		if(!validPosition(u)) {
			throw  new WalkInvalid("You go out of index");
		}
		if (GamePlay.turn == 2 && validPosition(u) && Map.m1[u[0]][u[1]] == 5 && Map.m2[u[0]][u[1]] == null
				&& c.getIsMrJack()) {
			GamePlay.indexToIVBoard(GamePlay.cha).setX(148 + 66 * u[1]);
			GamePlay.indexToIVBoard(GamePlay.cha).setY(100 + 66 * u[0]);

			if (GamePlay.cha == 6) {
				GamePlay.lightHaibara.setX(140 + 66 * u[1]);
				GamePlay.lightHaibara.setY(90 + 66 * u[0]);
			}

			c.walk(u);
			jackEscape = true;
			GamePlay.walk++;
			GamePlay.gamePane.getChildren().removeAll(GamePlay.arrowOne, GamePlay.arrowTwo, GamePlay.arrowThree,
					GamePlay.arrowFour, GamePlay.arrowFive);
			ImageView k = GamePlay.setCenter(Resloader.lose);
			GamePlay.gamePane.getChildren().add(k);
		}
		if (validPosition(u) && (Map.m1[u[0]][u[1]] == 1 || Map.m1[u[0]][u[1]] == 4) && Map.m2[u[0]][u[1]] == null) {

			GamePlay.indexToIVBoard(GamePlay.cha).setX(148 + 66 * u[1]);
			GamePlay.indexToIVBoard(GamePlay.cha).setY(100 + 66 * u[0]);

			if (GamePlay.cha == 6) {
				GamePlay.lightHaibara.setX(140 + 66 * u[1]);
				GamePlay.lightHaibara.setY(90 + 66 * u[0]);
			}

			c.walk(u);

			if (Map.m1[c.getIndexX()][c.getIndexY()] != 4) {
				GamePlay.walk++;
			}

			else {
				GamePlay.createWhereToGoToHole();
			}

		}
		

	}

	public static void isLight() {
		for (int index = 0; index < 8; index++) {

			Character character = allCharacter.get(index);
			int x = character.getIndexX();
			int y = character.getIndexY();
			int light = 0;
			for (int i = x - 1; i <= x + 1; i++) {
				for (int j = y - 1; j <= y + 1; j++) {
					int[] pos = new int[] { i, j };
					if (validPosition(pos)) {
						if (Map.m2[i][j] instanceof Lamp) {
							allCharacter.get(index).setIsLight(true);
							light = 1;
							break;
						}

					}
				}
				if (light == 1) {
					break;
				}
			}
			if (light == 0) {
				allCharacter.get(index).setIsLight(false);

			}

		}

		Haibara haibara = (Haibara) allCharacter.get(6);
		int dir = haibara.getDirectionLight();
		int x = haibara.getIndexX();
		int y = haibara.getIndexY();
		int c = 1;
		if (dir == 1) {
			while (true) {
				int[] index = new int[] { x, y - c };
				if (!validPosition(index) || Map.m1[x][y - c] == 2 || Map.m1[x][y - c] == 3 || Map.m1[x][y - c] == 5) {
					break;
				}
				if (Map.m2[x][y - c] instanceof Character) {
					Character cha = (Character) Map.m2[x][y - c];
					cha.setIsLight(true);
				}
				c++;
			}
		}
		if (dir == 2) {
			while (true) {
				int[] index = new int[] { x, y + c };
				if (!validPosition(index) || Map.m1[x][y + c] == 2 || Map.m1[x][y + c] == 3 || Map.m1[x][y + c] == 5) {
					break;
				}
				if (Map.m2[x][y + c] instanceof Character) {
					Character cha = (Character) Map.m2[x][y + c];
					cha.setIsLight(true);
				}
				c++;
			}
		}
		if (dir == 3) {
			while (true) {
				int[] index = new int[] { x - c, y };
				if (!validPosition(index) || Map.m1[x - c][y] == 2 || Map.m1[x - c][y] == 3 || Map.m1[x - c][y] == 5) {
					break;
				}
				if (Map.m2[x - c][y] instanceof Character) {
					Character cha = (Character) Map.m2[x - c][y];
					cha.setIsLight(true);
				}
				c++;
			}
		}
		if (dir == 4) {
			while (true) {
				int[] index = new int[] { x + c, y };
				if (!validPosition(index) || Map.m1[x + c][y] == 2 || Map.m1[x + c][y] == 3 || Map.m1[x + c][y] == 5) {
					break;
				}
				if (Map.m2[x + c][y] instanceof Character) {
					Character cha = (Character) Map.m2[x + c][y];
					cha.setIsLight(true);
				}
				c++;
			}
		}

		GamePlay.createIslight();
	}

	public static void isChoice() {
		boolean light = true;
		if (MrJack.getIsLight()) {
			light = true;

		} else {
			light = false;
		}

		for (int i = 0; i < 8; i++) {
			if (allCharacter.get(i).getIsChoice()) {
				if (allCharacter.get(i).getIsLight() != light) {
					allCharacter.get(i).setIsChoice(false);
				}
			}
		}

		for (int i = 0; i < 8; i++) {
			if (!allCharacter.get(i).getIsChoice()) {
				GamePlay.gamePane.getChildren().remove(GamePlay.isChoice.get(i));
				
			}
		}

		System.out.println("====In Choice====");
		choiceCharacter = new ArrayList<Character>();
		int c = 0;
		for (int i = 0; i < 8; i++) {
			if (allCharacter.get(i).getIsChoice()) {
				c++;
				System.out.println("[" + (c) + "]" + chaToName(allCharacter.get(i)) + " ");
				choiceCharacter.add(allCharacter.get(i));
			}
		}

		GamePlay.createIsChoice();

	}

	public static Character indexToCha(int index) {
		return allCharacter.get(index);
	}

	public static String chaToName(Character character) {
		return indexToName(chaToIndex(character));
	}

	public static String indexToName(int index) {
		String name = null;
		if (index == 0) {
			name = "gin";
		}
		if (index == 1) {
			name = "shadowMan";
		}
		if (index == 2) {
			name = "conan";
		}
		if (index == 3) {
			name = "kogoro";
		}
		if (index == 4) {
			name = "heiji";
		}
		if (index == 5) {
			name = "ran";
		}
		if (index == 6) {
			name = "haibara";
		}
		if (index == 7) {
			name = "kid";
		}

		return name;
	}

	public static int chaToIndex(Character cha) {
		int index = 0;
		if (cha instanceof Gin) {
			index = 0;
		}
		if (cha instanceof ShadowMan) {
			index = 1;
		}
		if (cha instanceof Conan) {
			index = 2;
		}
		if (cha instanceof Kogoro) {
			index = 3;
		}
		if (cha instanceof Heiji) {
			index = 4;
		}
		if (cha instanceof Ran) {
			index = 5;
		}
		if (cha instanceof Haibara) {
			index = 6;
		}
		if (cha instanceof Kid) {
			index = 7;
		}
		return index;
	}

}
