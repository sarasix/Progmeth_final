package logic;

public class Ran extends Character {
	
	private int walk;
	public Ran(int indexX,int indexY,boolean isLight) {
		super(indexX,indexY,isLight);
		walk=3;
		
	}
	public boolean ability(int indexX, int indexY,ExitBarricade e) {
		//ย้ายที่กั้นทางออก
		boolean j=e.movable(indexX, indexY);
		return j;
		
	}
	public int getWalk() {
		return walk;
	}
	@Override
	
}
