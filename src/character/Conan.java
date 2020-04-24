package character;

import java.util.Random;
import main.Main;


public class Conan extends Character {
	public static int choice;
	public Conan(int indexX,int indexY, boolean isLight) {
		super(indexX,indexY,isLight,3);
		//this.walk=3;
	}
	
	 
	
	public void ability() {
		//remove one innocence from choice
		//e.remove();
		while(true)
		{
			Random rand = new Random();
			int i =   rand.nextInt(8);
			if(!Main.indexToCha(i).getIsMrJack()) {
				if(Main.indexToCha(i).getIsChoice()) {
					Main.indexToCha(i).setIsChoice(false);
					System.out.println(i+" removed from choice");
					choice = i;
					break;
				}
			}
			
		}
		
	}
	
}
