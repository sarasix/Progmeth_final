package character;

import map.PutMap;

public class Character extends PutMap{
	//private int indexX;
	//private int indexY;
	private boolean isChoice;
	private boolean isMrJack;
	private boolean isLight;
	
	
	public Character(int indexX,int indexY, boolean isLight)
	{
		super(indexX,indexY);
		this.isChoice=true;
		this.isMrJack=false;
		this.isLight=isLight;
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
	
	
	
}