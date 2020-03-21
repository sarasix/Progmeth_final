package logic;

public class Heiji extends Character{
	private int walk;
	public Heiji(int indexX,int indexY,boolean isLight)
	{
		super(indexX,indexY,isLight);
		this.walk=3;
	}
	public boolean ability() {
		
	}
	public int getWalk() {
		return walk;
	}

}
