package item;

import character.Movable;

public class ExitBarricade extends Item implements Movable{
	public ExitBarricade(int indexX,int indexY) {
		super(indexX,indexY);
	}
	//������ moveable interface
	public boolean movable(int indexX,int indexY) {
		if(this.getIndexX()==indexX && this.getIndexY()==indexY) {
			return false;
		}
		if(m1[indexX][indexY] == 5) {
			if(m2[indexX][indexY]] has nothing) {
				m2[indexX][indexY]= this.Exitbarricade ����ѹ;
				int indexXPrevious=this.getIndexX();
				int indexYPrevious=this.getIndexY();
				m2[indexXPrevious][indexYPrevious] = ����͡;
				this.setIndexX(indexX);
				this.setIndexY(indexY);
				return true;
				
			}
			
		}
		return false;
	}

}
