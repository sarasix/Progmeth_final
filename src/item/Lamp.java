package item;

import character.Movable;

public class Lamp extends Item implements Movable {
	public Lamp(int indexX,int indexY) {
		super(indexX,indexY);
	}
	// เดี๋ยวมี interface moveable
	public boolean movable(int indexX,int indexY) {
		if (this.getIndexX()==indexX && this.getIndexY()==indexY)
			return false;
		if(m1[indexX][indexY] == 3) //spaceforlight
		{
			if(m2[indexX][indexY] has Nothing)
			{
				m2[indexX][indexY] =this.lamp
				int indexXPrevious=this.getIndexX();
				int indexYPrevious=this.getIndexY();
				this.setIndexX(indexX);
				this.setIndexY(indexY);
				m2[indexXPrevious][indexYPrevious] = เอาออก;
				return true;
			}
			
			
		}
		return false;
	}
	

}
