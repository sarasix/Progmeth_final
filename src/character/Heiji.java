package character;

import java.util.Scanner;

import item.HoleCover;
import map.Map;
import map.PutMap;

public class Heiji extends Character {
	
	public Heiji(int indexX,int indexY,boolean isLight)
	{
		super(indexX,indexY,isLight,3);
		//this.walk=3;
	}
	public void ability() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Choose a hole cover");
		int input=scan.nextInt();
		HoleCover t=Map.allHoleCover.get(input);
		System.out.println("Choose a hole you want to cover");
		boolean U;
		do
		{
			int indexXHole=scan.nextInt();
			int indexYHole=scan.nextInt();
			U=t.movable(indexXHole,indexYHole);
		}while(!U);
		
		
	}
	

}
