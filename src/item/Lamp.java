package item;

import character.Movable;
import map.Map;
import map.PutMap;

public class Lamp extends Item implements Movable {
	public Lamp(int indexX,int indexY) {
		super(indexX,indexY);
	}
	
	
	
	
	// เดี๋ยวมี interface moveable
	public boolean movable(int indexX,int indexY,Object t) {
		if (this.getIndexX()==indexX && this.getIndexY()==indexY)
			return false;
		if(!(t instanceof Map))
			return false;
		if(((Map) t).getM1(indexX, indexY) == 3) //spaceforlight
		{
			if(((Map) t).getM2(indexX, indexY) == null )
			{
				
				int indexXPrevious=this.getIndexX();
				int indexYPrevious=this.getIndexY();
				this.setIndexX(indexX);
				this.setIndexY(indexY);
				PutMap N= new PutMap(indexX,indexY);
				((Map) t).setM2(((Map) t).getM2(indexX, indexY), N);
				((Map) t).setM2(((Map) t).getM2(indexXPrevious, indexYPrevious), null);
				return true;
			}
			
			
		}
		return false;
	}
	

}
