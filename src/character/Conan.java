package character;

import java.util.Random;

import round.Round;

public class Conan extends Character implements Walk {
	private int walk;
	public Conan(int indexX,int indexY, boolean isLight) {
		super(indexX,indexY,isLight);
		this.walk=3;
	}
	
	 
	
	public boolean ability() {
		//remove one innocence from choice
		//e.remove();
		while(true)
		{
			Random rand = new Random();
			int i =   rand.nextInt(8);
			if(Round.indexToCha(i).getIsChoice()) {
				Round.indexToCha(i).setIsChoice(false);
				break;
			}
		}
		return true;
		
	}
	public int getWalk() {
		return this.walk;
	}
	public int[] walk(int dir) {
		int indexX=this.getIndexX();
		int indexY=this.getIndexY();
		int[] k = new int[2];
		//1left 2right 3up 4down
		if(dir == 1) {
			k[0]=indexX-1;
			k[1]=indexY;
			
			
		} else if (dir==2) {
			k[0]=indexX+1;
			k[1]=indexY;
			
		} else if (dir==3) {
			k[0]=indexX;
			k[1]=indexY-1;
		} else if (dir==4) {
			k[0]=indexX;
			k[1]=indexY+1;
		}
		return k;
	}

}
