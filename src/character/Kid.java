package character;

public class Kid extends Character{
	private int walk;
	public Kid(int indexX, int indexY,boolean isLight) {
		super(indexX,indexY,isLight);
		walk=4;
		
	}
	public boolean ability() {
		return true;
	}
	public int getWalk() {
		return walk;
	}

}
