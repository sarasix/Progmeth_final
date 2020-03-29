package item;

import character.Movable;
import map.Map;
import map.PutMap;

public class Item extends PutMap implements Movable{
	
	private int typeField;
	private int number;
	public Item(int indexX,int indexY,int typeField,int number) {
		super(indexX,indexY);
		this.typeField=typeField;
		Map.m2[indexX][indexY] = this;
		this.number=number;
		
		
	}
	public boolean movable(int indexX,int indexY) {
		if (this.getIndexX()==indexX && this.getIndexY()==indexY)
			return false;
		
		if(Map.m1[indexX][indexY] == this.typeField) //spaceforlight
		{
			if(Map.m2[indexX][indexY] == null )
			{
				
				int indexXPrevious=this.getIndexX();
				int indexYPrevious=this.getIndexY();
				this.setIndexX(indexX);
				this.setIndexY(indexY);
				//PutMap N= new PutMap(indexX,indexY);
				Map.m2[indexX][indexY]=this;
				Map.m2[indexXPrevious][indexYPrevious]=null;
				return true;
			}
			
			
		}
		return false;
	}
	
}
