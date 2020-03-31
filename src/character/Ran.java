package character;

import java.util.Scanner;

import item.ExitBarricade;
import item.HoleCover;
import main.Main;
import map.Map;

public class Ran extends Character{
	
	
	public Ran(int indexX,int indexY,boolean isLight) {
		super(indexX,indexY,isLight,3);
		
		
	}
	public void ability() {
		Main.itemChosen.movable();
		
		
		
	}
}
