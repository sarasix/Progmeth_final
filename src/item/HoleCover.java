package logic;

public class HoleCover extends Item implements Movable{
	public HoleCover(int indexX,int indexY) {
		super(indexX,indexY);
	}
	// เดี๋ยวมี interface moveable
	public boolean movable(int indexX,int indexY) {
		if(this.getIndexX()==indexX && this.getIndexY) {
			return false;
		}
		if(m1[indexX][indexY]==4) {
			if(m2[indexX][indexY] has nothing) {
				m2[indexX][indexY] = this.HoleCover;
				int indexXPrevious=this.getIndexX();
				int indexYPrevious=this.getIndexY();
				this.setIndexX(indexX);
				this.setIndexY(indexY);
				m2[indexXPrevious][indexYPrevious] = เอาออก;
				return true
			}
		}
		return false;
	}
	

}
