package character;

public class Kogoro extends Character{
	private int walk;
	public Kogoro(int indexX,int indexY,boolean isLight) {
		super(indexX,indexY,isLight);
		walk=3;
	}
	public void ability() {
		//ÂéÒÂä¿
	}
	public int getWalk() {
		return walk;
	}

}
