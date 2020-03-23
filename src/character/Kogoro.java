package character;

import item.Lamp;

public class Kogoro extends Character{
	private int walk;
	public Kogoro(int indexX,int indexY,boolean isLight) {
		super(indexX,indexY,isLight);
		walk=3;
	}
	public boolean ability(int indexX,int indexY,Object t) {
		if(t instanceof Lamp) {
			return ((Lamp) t).movable(indexX,indexY);
		}
		
		
		return false;
	}
	public int getWalk() {
		return walk;
	}


}
