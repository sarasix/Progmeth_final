package character;

import java.util.Random;

import round.Round;

public class Conan extends Character {
	private int walk;
	public Conan(int indexX,int indexY, boolean isLight) {
		super(indexX,indexY,isLight);
		this.walk=3;
	}
	public boolean ability() {
		//remove one innocence from choice
		//e.remove();
		while(true)
		{
			Random rand = new Random();
			int i =   rand.nextInt(8);
			if(Round.indexToCha(i).getIsChoice()) {
				Round.indexToCha(i).setIsChoice(false);
				break;
			}
		}
		return true;
		
	}
	public int getWalk() {
		return this.walk;
	}

}
