package character;

import item.HoleCover;

public class Heiji extends Character{
	private int walk;
	public Heiji(int indexX,int indexY,boolean isLight)
	{
		super(indexX,indexY,isLight);
		this.walk=3;
	}
	public boolean ability(int indexX,int indexY,Object t,Object y) {
		if(t instanceof HoleCover) {
			return ((HoleCover) t).movable(indexX,indexY,y);
			
		}
		return false;
		
	}
	public int getWalk() {
		return walk;
	}

}
