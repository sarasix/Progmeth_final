package character;

import map.Map;
import map.PutMap;

public class Character extends PutMap implements Walk {

	private boolean isChoice;
	private boolean isMrJack;
	private boolean isLight;
	private int walk;

	public Character(int indexX, int indexY, boolean isLight, int walk) {
		super(indexX, indexY);
		this.isChoice = true;
		this.isMrJack = false;
		this.isLight = isLight;
		this.walk = walk;

	}

	public int getWalk() {
		return this.walk;
	}

	public boolean getIsChoice() {
		return this.isChoice;
	}

	public void setIsChoice(boolean isChoice) {
		this.isChoice = isChoice;
	}

	public void setIsMrJack(boolean isJack) {
		this.isMrJack = isJack;
	}

	public boolean getIsMrJack() {
		return this.isMrJack;
	}

	public boolean getIsLight() {
		return isLight;
	}

	public void setIsLight(boolean isLight) {
		this.isLight = isLight;
	}

	public void walk(int[] k) {
		int indexXPrevious = this.getIndexX();
		int indexYPrevious = this.getIndexY();
		Map.m2[indexXPrevious][indexYPrevious] = null;
		this.setIndexX(k[0]);
		this.setIndexY(k[1]);
		Map.m2[k[0]][k[1]] = this;
		System.out.println("Your character moved from position " + indexXPrevious + " " + indexYPrevious + " to " + k[0]
				+ " " + k[1]);

	}

}