package character;

import item.HoleCover;

public class Heiji extends Character {
	
	public Heiji(int indexX,int indexY,boolean isLight)
	{
		super(indexX,indexY,isLight,3);
		//this.walk=3;
	}
	public boolean ability(int indexX,int indexY,Object t) {
		if(t instanceof HoleCover) {
			return ((HoleCover) t).movable(indexX,indexY);
			
		}
		return false;
		
	}
	

}
