package character;

import java.util.Scanner;

import main.Main;


public class Gin extends Character{
	
	public Gin(int indexX,int indexY,boolean isLight) {
		super(indexX,indexY,isLight,3);
		//walk=3;
	}
    public void ability() {
    	//���¡����Ф������������ 1-3 ��ͧ
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Choose a character to walk");
    	int h= scan.nextInt();
    	Character m= Main.indexToCha(h);
    	
    }
    
}
