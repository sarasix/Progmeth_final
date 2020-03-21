package logic;

public class Conan extends Character {
	private int walk;
	public Conan(int indexX,int indexY, boolean isLight) {
		super(indexX,indexY,isLight);
		this.walk=3;
	}
	public boolean ability() {
		//remove one innocence from choice
		//e.remove();
	}
	public int getWalk() {
		return this.walk;
	}

}
