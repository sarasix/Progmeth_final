package character;

import java.util.Scanner;

public class Haibara extends Character {
	
	private int directionLight; // 1left 2right 3up 4down
	public Haibara(int indexX,int indexY,boolean isLight) {
		super(indexX,indexY,isLight,3);
		//this.walk=3;
		this.directionLight=0;
	}
	public void setDirectionLight(int h) {
		this.directionLight=h;
	}
	public int getDirectionLight() {
		return this.directionLight;
	}
	public void ability() {
		//ส่องแสงไปทิศไหนก็ได้
		Scanner scan= new Scanner(System.in);
		
		int h;
		do
		{
			h=scan.nextInt();
		}while (!(h<=4 && h>=1));
		directionLight=h;
	}
	

}
