package character;

import java.util.Scanner;

import map.Map;
import round.Round;

public class ShadowMan extends Character {
	//private int walk;
	public ShadowMan(int indexX, int indexY,boolean isLight) {
		super(indexX,indexY,isLight,3);
		//walk=3;
	}
	public void ability() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Choose a character you want to switch with");
		int G=scan.nextInt();
		Character P=Round.indexToCha(G);
		
		int indexXOther=P.getIndexX();
		int indexYOther=P.getIndexY();
			
		P.setIndexX(this.getIndexX());
		P.setIndexY(this.getIndexY());
		Map.m2[P.getIndexX()][P.getIndexY()]=P;
		this.setIndexX(indexXOther);
		this.setIndexY(indexYOther);
		Map.m2[this.getIndexX()][this.getIndexY()]=this;
		
		
		
		
		
	}
}
