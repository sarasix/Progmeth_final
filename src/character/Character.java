package character;

import map.PutMap;

public abstract class Character extends PutMap implements Walk{
	//private int indexX;
	//private int indexY;
	private boolean isChoice;
	private boolean isMrJack;
	private boolean isLight;
	private int walk;
	
	public Character(int indexX,int indexY, boolean isLight,int walk)
	{
		super(indexX,indexY);
		this.isChoice=true;
		this.isMrJack=false;
		this.isLight=isLight;
		this.walk=walk;
	}
	
	public int getWalk() {
		return this.walk;
	}
	public boolean getIsChoice() {
		return this.isChoice;
	}
	public void setIsChoice(boolean isChoice) {
		this.isChoice=isChoice;
	}
	
	public void setIsMrJack() {
		this.isMrJack=true;
	}
	public boolean getIsMrJack() {
		return this.isMrJack;
	}
	public boolean getIsLight() {
		return isLight;
	}
	public void setIsLight(boolean isLight) {
	    this.isLight=isLight;	
	}
	public int[] walk(int dir) {
		int indexX=this.getIndexX();
		int indexY=this.getIndexY();
		int[] k = new int[2];
		//1left 2right 3up 4down
		if(dir == 1) {
			k[0]=indexX-1;
			k[1]=indexY;
			
			
		} else if (dir==2) {
			k[0]=indexX+1;
			k[1]=indexY;
			
		} else if (dir==3) {
			k[0]=indexX;
			k[1]=indexY-1;
		} else if (dir==4) {
			k[0]=indexX;
			k[1]=indexY+1;
		}
		return k;
	}
	public abstract void ability();

	
}