package character;

public class ShadowMan extends Character{
	private int walk;
	public ShadowMan(int indexX, int indexY,boolean isLight) {
		super(indexX,indexY,isLight);
		walk=3;
	}
	public void ability() {
		
	}
	public int getWalk() {
		return walk;
	}

}
