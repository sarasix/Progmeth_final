package character;

public class ShadowMan extends Character{
	private int walk;
	public ShadowMan(int indexX, int indexY,boolean isLight) {
		super(indexX,indexY,isLight);
		walk=3;
	}
	public boolean ability(Object t) {
		
		if(t instanceof Character) {
			int indexXOther=((Character)t).getIndexX();
			int indexYOther=((Character)t).getIndexY();
			((Character) t).setIndexX(this.getIndexX());
			((Character) t).setIndexY(this.getIndexY());
			this.setIndexX(indexXOther);
			this.setIndexY(indexYOther);
		}
		
		return false;
		
	}
	public int getWalk() {
		return walk;
	}

}
