package logic;

public class ShadowMan extends Character{
	private int walk;
	public ShadowMan(int indexX, int indexY,boolean isLight) {
		super(indexX,indexY,isLight);
		walk=3;
	}
	public void ability(Character Other) {
		int indexXOther=Other.getIndexX();
		int indexYOther=Other.getIndexY();
		Other.setIndexX(this.getIndexX());
		Other.setIndexY(this.getIndexY());
		this.setIndexX(indexXOther);
		this.setIndexY(indexYOther);
		
		
	}
	public int getWalk() {
		return walk;
	}

}
