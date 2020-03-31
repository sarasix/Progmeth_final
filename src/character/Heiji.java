package character;

import java.util.Scanner;



import item.HoleCover;
import map.Map;
import map.PutMap;
import main.Main;

public class Heiji extends Character {
	
	public Heiji(int indexX,int indexY,boolean isLight)
	{
		super(indexX,indexY,isLight,3);
		//this.walk=3;
	}
	public void ability() {
		Main.itemChosen.movable();
		
		
	}
	

}
