package character;

import java.util.Scanner;

import item.HoleCover;
import item.Lamp;
import main.Main;
import map.Map;

public class Kogoro extends Character{

	public Kogoro(int indexX,int indexY,boolean isLight) {
		super(indexX,indexY,isLight,3);
		
	}
	public void ability() {
		Main.itemChosen.movable();
	}
	
	


}
