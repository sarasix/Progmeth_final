package character;

import java.util.Scanner;

import main.Main;

import map.Map;

public class ShadowMan extends Character {
	//private int walk;
	public ShadowMan(int indexX, int indexY,boolean isLight) {
		super(indexX,indexY,isLight,3);
		//walk=3;
	}
	public void ability() {
		
		
		int indexXOther=Main.CharacterOther.getIndexX();
		int indexYOther=Main.CharacterOther.getIndexY();
			
		Main.CharacterOther.setIndexX(this.getIndexX());
		Main.CharacterOther.setIndexY(this.getIndexY());
		Map.m2[Main.CharacterOther.getIndexX()][Main.CharacterOther.getIndexY()]=Main.CharacterOther;
		this.setIndexX(indexXOther);
		this.setIndexY(indexYOther);
		Map.m2[this.getIndexX()][this.getIndexY()]=this;
		
		
		
		
		
	}
}
