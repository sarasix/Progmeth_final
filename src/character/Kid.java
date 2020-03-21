package character;

public class Kid extends Character{
	private int walk;
	public Kid(int indexX, int indexY,boolean isLight) {
		super(indexX,indexY,isLight);
		walk=4;
		
	}
	public void ability() {
		
	}
	public int getWalk() {
		return walk;
	}

}
