package item;

import map.putMap;

public class Item extends putMap{
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
	public void setIndexX(int indexX) {
		this.indexX=indexX;
	}
	public void setIndexY(int indexY) {
		this.indexY=indexY;
	}

}
