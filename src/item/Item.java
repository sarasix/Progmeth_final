package item;

import map.PutMap;

public class Item extends PutMap{
	private int indexX;
	private int indexY;
	
	public Item(int indexX,int indexY) {
		super(indexX,indexY);
	}
	
	public int getIndexX() {
		return indexX;
	}
	public int getIndexY() {
		return indexY;
	}
}
