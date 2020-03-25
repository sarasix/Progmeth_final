package character;

import item.ExitBarricade;

public class Ran extends Character{
	
	private int walk;
	public Ran(int indexX,int indexY,boolean isLight) {
		super(indexX,indexY,isLight);
		walk=3;
		
	}
	public boolean ability(int indexX, int indexY,Object t,Object y) {
		//ย้ายที่กั้นทางออก
		if(t instanceof ExitBarricade) {
			return ((ExitBarricade) t).movable(indexX,indexY,y);
		}
		return false;
	}
	public int getWalk() {
		return walk;
	}

}
