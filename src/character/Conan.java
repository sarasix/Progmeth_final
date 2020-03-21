package character;

import character.Character;;

public class Conan extends Character {
	private int walk;
	public Conan(int indexX,int indexY, boolean isLight) {
		super(indexX,indexY,isLight);
		this.walk=3;
	}
	public void ability() {
		//remove one innocence from choice
		//e.remove();
	}
	public int getWalk() {
		return this.walk;
	}

}
