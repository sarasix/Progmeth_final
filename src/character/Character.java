package character;

import java.util.Scanner;

import map.Map;
import map.PutMap;

public class Character extends PutMap implements Walk{
	//private int indexX;
	//private int indexY;
	private boolean isChoice;
	private boolean isMrJack;
	private boolean isLight;
	private int walk;
	
	public Character(int indexX,int indexY, boolean isLight,int walk)
	{
		super(indexX,indexY);
		this.isChoice=true;
		this.isMrJack=false;
		this.isLight=isLight;
		this.walk=walk;

	}
	
	public int getWalk() {
		return this.walk;
	}
	public boolean getIsChoice() {
		return this.isChoice;
	}
	public void setIsChoice(boolean isChoice) {
		this.isChoice=isChoice;
	}
	
	public void setIsMrJack() {
		this.isMrJack=true;
	}
	public boolean getIsMrJack() {
		return this.isMrJack;
	}
	public boolean getIsLight() {
		return isLight;
	}
	public void setIsLight(boolean isLight) {
	    this.isLight=isLight;	
	}
	public void walk() {
		Scanner scan = new Scanner(System.in);
		int dir;
		//boolean invalid;
		int step;
		do {
			step=scan.nextInt();
		}while(!(step>=1&&step<=this.walk));
		for(int i=1;i<=step;i++) {
			do
			{
				
	//			invalid=true;
				do
				{
					dir= scan.nextInt();
				}
				while(!(dir<=4&&dir>=1));
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
				if(k[0]>=0&&k[0]<=12&&k[1]>=0&&k[1]<=6) {
					if(Map.m1[k[0]][k[1]]==1) {
						if(Map.m2[k[0]][k[1]]==null) {
							int indexXPrevious=this.getIndexX();
							int indexYPrevious=this.getIndexY();
							Map.m2[indexXPrevious][indexYPrevious]=null;
							this.setIndexX(k[0]);
							this.setIndexY(k[1]);
							Map.m2[k[0]][k[1]]=this;
							break;
						}
						
					
					
					}else if(Map.m1[k[0]][k[1]]==4) {
						if(Map.m2[k[0]][k[1]]==null) {
							System.out.println("Choose a hole you want to appear");
							
							
							
						    int indexXHole=scan.nextInt();
							int indexYHole=scan.nextInt();
								
							
							
							
							int indexXPrevious=this.getIndexX();
							int indexYPrevious=this.getIndexY();
							Map.m2[indexXPrevious][indexYPrevious]=null;
							this.setIndexX(indexXHole);
							this.setIndexY(indexYHole);
							Map.m2[indexXHole][indexYHole]=this;
							break;
							
							
							
						
						}
					}
						
					
						
					
				}
					
				
			}while(true);
			
		}
		
		
			
		
		
	}
	

	
}