package character;

import map.Map;

public class ShadowMan extends Character{
	private int walk;
	public ShadowMan(int indexX, int indexY,boolean isLight) {
		super(indexX,indexY,isLight);
		walk=3;
	}
	public boolean ability(Object t,Object y) {
		
		if(!(y instanceof Map))
			return false;
		if(t instanceof Character) {
			int indexXOther=((Character)t).getIndexX();
			int indexYOther=((Character)t).getIndexY();
			
			((Character) t).setIndexX(this.getIndexX());
			((Character) t).setIndexY(this.getIndexY());
			this.setIndexX(indexXOther);
			this.setIndexY(indexYOther);
			return true;
		}
		
		return false;
		
	}
	public int getWalk() {
		return walk;
	}

}
