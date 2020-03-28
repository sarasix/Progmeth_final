package character;

import item.ExitBarricade;

public class Ran extends Character{
	
	
	public Ran(int indexX,int indexY,boolean isLight) {
		super(indexX,indexY,isLight,3);
		
		
	}
	public boolean ability(int indexX, int indexY,Object t) {
		//���·���鹷ҧ�͡
		if(t instanceof ExitBarricade) {
			return ((ExitBarricade) t).movable(indexX,indexY);
		}
		return false;
	}
}
