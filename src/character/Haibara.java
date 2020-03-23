package character;

public class Haibara extends Character{
	private int walk;
	public Haibara(int indexX,int indexY,boolean isLight) {
		super(indexX,indexY,isLight);
		this.walk=3;
	}
	public boolean ability()
	{
		//ส่องแสงไปทิศไหนก็ได้
		return true;
		
	}
	public int getWalk() {
		return this.walk;
	}

}
