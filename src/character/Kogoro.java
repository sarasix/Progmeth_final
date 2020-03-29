package character;

import java.util.Scanner;

import item.HoleCover;
import item.Lamp;
import map.Map;

public class Kogoro extends Character{

	public Kogoro(int indexX,int indexY,boolean isLight) {
		super(indexX,indexY,isLight,3);
		
	}
	public void ability(int indexX,int indexY) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Choose a lamp");
		int input=scan.nextInt();
		Lamp t=Map.allLamp.get(input);
		System.out.println("Choose a lamp space you want to place");
		boolean K;
		do
		{
			int indexXLampSpace=scan.nextInt();
			int indexYLampSpace=scan.nextInt();
			K=t.movable(indexXLampSpace,indexYLampSpace);
		}while(!K);
		
		//return t.movable(indexXLampSpace,indexYLampSpace);
	}
	


}
