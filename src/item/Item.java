package item;

import character.Movable;
import main.Main;
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
	public void movable() {
		int indexXPrevious=this.getIndexX();
		int indexYPrevious=this.getIndexY();
		this.setIndexX(Main.indexItemField[0]);
		this.setIndexY(Main.indexItemField[1]);
				//PutMap N= new PutMap(indexX,indexY);
		Map.m2[Main.indexItemField[0]][Main.indexItemField[1]]=this;
		Map.m2[indexXPrevious][indexYPrevious]=null;
			
	}
	public int getNumber() {
		return this.number;
	}
	public int getTypeField() {
		return this.typeField;
	}
	
}
