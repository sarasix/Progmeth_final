package character;

import java.util.Scanner;

import item.ExitBarricade;
import item.HoleCover;
import map.Map;

public class Ran extends Character{
	
	
	public Ran(int indexX,int indexY,boolean isLight) {
		super(indexX,indexY,isLight,3);
		
		
	}
	public void ability() {
		//ย้ายที่กั้นทางออก
		Scanner scan = new Scanner(System.in);
		System.out.println("Choose an exit barricade");
		int input=scan.nextInt();
		ExitBarricade t=Map.allExitBarricade.get(input);
		System.out.println("Choose an exit you want to close");
		boolean h;
		do
		{
			int indexXExit=scan.nextInt();
			int indexYExit=scan.nextInt();
			h=t.movable(indexXExit,indexYExit);
		}while(!h);
		
		
		
	}
}
