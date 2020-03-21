package logic;

public class Kid extends Character{
	private int walk;
	public Kid(int indexX, int indexY,boolean isLight) {
		super(indexX,indexY,isLight);
		walk=4;
		
	}
	public boolean ability() {
		
	}
	public int getWalk() {
		return walk;
	}

}
