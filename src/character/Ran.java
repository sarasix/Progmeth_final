package character;

public class Ran extends Character {
	private int walk;
	public Ran(int indexX,int indexY,boolean isLight) {
		super(indexX,indexY,isLight);
		walk=3;
		
	}
	public void ability() {
		//ย้ายที่กั้นทางออก
		
	}
	public int getWalk() {
		return walk;
	}

}
