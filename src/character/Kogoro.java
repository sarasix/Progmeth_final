package character;

import item.Lamp;

public class Kogoro extends Character{

	public Kogoro(int indexX,int indexY,boolean isLight) {
		super(indexX,indexY,isLight,3);
		
	}
	public boolean ability(int indexX,int indexY,Object t) {
		if(t instanceof Lamp) {
			return ((Lamp) t).movable(indexX,indexY);
		}
		
		
		return false;
	}
	


}
