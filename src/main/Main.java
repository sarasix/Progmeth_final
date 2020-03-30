package main;
import initial.*;
import item.*;
import java.util.*;

import character.*;
import character.Character;
import map.Map;

public class Main {
	public static Initial initial = new Initial();	
	public static ArrayList<Integer> choice = initial.getChoice();
	public static ArrayList<String> order1 = initial.getOrder1();
	public static ArrayList<String> order2 = initial.getOrder2();
	public static ArrayList<String> order = new ArrayList<String>();
	public static Map map = initial.getMap();
	public static ArrayList<Character> allCharacter = initial.getAllCharacter();
	public static int dir;		
	public static int step;
	public static int inputCard;
	public static ArrayList<Character> card4 = new ArrayList<Character>();
	
	public static Random rand = new Random();
	public static Scanner scan = new Scanner(System.in);
	
	private static int randomNumber;
	
	
	
	public static void main(String[] arg) {
		System.out.println("start");
		loopRound();
	
	}
	public static void loopRound (){
		for(int i=0;i<8;i++) {
			System.out.println("round"+(i+1));
			if(i%2 == 0) {
				order = order1;
			}
			else {
				order = order2;
			}
			round(initial.getLawRemoveItem(i,0),initial.getLawRemoveItem(i,1) , initial.getLawRemoveItem(i,2),order);
			
		}

	}
	public static void round(int numLamp,int numExitBarricade,int numHoleCover,ArrayList<String> order) {
		removeItem(numLamp,numExitBarricade,numHoleCover);
		
		randomCard();
		play();
		
		
	}
	public static void printMap() {
		for(int i = 0 ; i< 7;i++) {
			for(int j = 0 ;j<13; j++) {				
				if(Map.m2[i][j] != null) {				
					if(Map.m2[i][j] instanceof Lamp) {
						System.out.print("E"+ " ");
					}
					else if(Map.m2[i][j]instanceof ExitBarricade) {
						System.out.print("X"+ " ");
					}
					else if(Map.m2[i][j]instanceof HoleCover) {
						System.out.print("O"+ " ");
					}
					else {
						System.out.print("*"+ " ");
					}					
				}
				else{
					System.out.print(map.getM1(i, j)+ " ");
				}
			}
			System.out.print("\n");
			
			
		}			
	}
	
	public static void removeItem(int numLamp,int numExitBarricade,int numHoleCover) {
		
		if(Map.allLamp.size() > numLamp)
		{
			randomNumber =   rand.nextInt(Map.allLamp.size());
			System.out.println("Lamp remove!!");
			Map.m2[Map.allLamp.get(randomNumber).getIndexX()][ Map.allLamp.get(randomNumber).getIndexY()] = null;
			Map.allLamp.remove(randomNumber);
			
		}
		if(Map.allExitBarricade.size() > numExitBarricade)
		{
			randomNumber =   rand.nextInt(Map.allExitBarricade.size());
			System.out.println("ExitBarricade remove!!");
			Map.m2[Map.allExitBarricade.get(randomNumber).getIndexX()][ Map.allExitBarricade.get(randomNumber).getIndexY()] = null;
			Map.allExitBarricade.remove(randomNumber);
			
		}
		if(Map.allHoleCover.size() > numHoleCover)
		{
			randomNumber =   rand.nextInt(Map.allHoleCover.size());
			System.out.println("HoleCover remove!!");
			Map.m2[Map.allHoleCover.get(randomNumber).getIndexX()][ Map.allHoleCover.get(randomNumber).getIndexY()] = null;
			Map.allHoleCover.remove(randomNumber);
			
		}	
	}
		
	public static void randomCard() {

		card4 = new ArrayList<Character>();
		for(int i = 0; i<4 ; i++)
		{
			while(true)
			{
				randomNumber =   rand.nextInt(8);		
				if(i!=0) {
					if(!card4.contains(allCharacter.get(randomNumber))) {
						break;	
					}
				}
				else {
					break;
				}
			}
			card4.add(allCharacter.get(randomNumber));
		}		
		
	}
	public static boolean validPosition(int[] pos) {
		if(pos[0]>=0&&pos[0]<=6&&pos[1]>=0&&pos[1]<=12) {
			return true;
		}
		return false;
	}
    public static int[] dirToPosition() {
    	int[] k = new int[2];
    	if(dir == 1) {
			k[0]=card4.get(inputCard-1).getIndexX();
			k[1]=card4.get(inputCard-1).getIndexY()-1;
			
			
		} else if (dir==2) {
			k[0]=card4.get(inputCard-1).getIndexX();
			k[1]=card4.get(inputCard-1).getIndexY()+1;
			
			
		} else if (dir==3) {
			k[0]=card4.get(inputCard-1).getIndexX()-1;
			k[1]=card4.get(inputCard-1).getIndexY();
		} else if (dir==4) {
			k[0]=card4.get(inputCard-1).getIndexX()+1;
			k[1]=card4.get(inputCard-1).getIndexY();
		}
    	return k;
    }
	public static void play() {
		for(int i=0;i<4;i++) {
			printMap();
			if(order.get(i)=="D") {
				System.out.println("=====Detective=====");
				}
			else {
				System.out.println("=====MrJack=====");
			}
			for(int j=0 ;j<(4-i);j++) {			
				System.out.print("["+(j+1)+"]"+indexToName(chaToIndex(card4.get(j)))+" ");
				
			}
			System.out.println();
			System.out.println("Please select card");
			inputCard = scan.nextInt();
			int inputNum;
			int[] u= new int[2]; 
			if(card4.get(inputCard-1) instanceof Haibara) {
				do {
					System.out.println("How many steps you want to walk? Maximum: "+card4.get(inputCard-1).getWalk());
					step=scan.nextInt();
				}while(!(step>=1&&step<=card4.get(inputCard-1).getWalk()));
				for(int j=1;j<=step;j++) {
					
					do
					{
						
						do
						{
							System.out.println("step"+j+"Please insert walk direction : [1]<- [2]-> [3]^ [4]v");
							dir= scan.nextInt();
						}while(!(dir<=4&&dir>=1));
						
						u=dirToPosition();
						if(validPosition(u)&&Map.m1[u[0]][u[1]]==1&&Map.m2[u[0]][u[1]]==null) {
							card4.get(inputCard-1).walk(u);
							break;
						}
						if (validPosition(u)&&Map.m1[u[0]][u[1]]==4&&Map.m2[u[0]][u[1]]==null) {
							System.out.println("Choose a hole you want to appear: ");
							int indexXHole;
							int indexYHole;
							int[] newU=new int[2];
							do
							{
								System.out.print("Insert a row for your hole position: ");
								indexXHole=scan.nextInt();
								System.out.print("\nInsert a column for your hole position: ");
								indexYHole=scan.nextInt();
								newU[0]=indexXHole;
								newU[1]=indexYHole;
							}while(!(validPosition(newU)&&Map.m1[newU[0]][newU[1]]==4&&Map.m2[newU[0]][newU[1]]==null));
							card4.get(inputCard-1).walk(newU);
							break;
						}
								
					       
						
					}while(true);
					
					
				}
				int j;
				do
				{
					System.out.println("Choose the direction for your Haibara's Light: [1]<- [2]-> [3] ^  [4] v");
					j=scan.nextInt();
				}while(!(j>=1&&j<=4));
				((Haibara) card4.get(inputCard-1)).setDirectionLight(j);
				
			}
			else if (card4.get(inputCard-1) instanceof Kid) {
			
				
			}
			else{
				
				do
				{
					System.out.println("[1]walk [2]ability");
					inputNum = scan.nextInt();
				}while(!(inputNum==1||inputNum==2));
				
				if(inputNum==1) {
					//int[] u= new int[2];
					do {
						System.out.println("How many steps you want to walk? Maximum: "+card4.get(inputCard-1).getWalk());
						step=scan.nextInt();
					}while(!(step>=1&&step<=card4.get(inputCard-1).getWalk()));
					for(int j=1;j<=step;j++) {
						
						do
						{
							
							do
							{
								System.out.println("step"+j+"Please insert walk direction : [1]<- [2]-> [3]^ [4]v");
								dir= scan.nextInt();
							}while(!(dir<=4&&dir>=1));
							
							u=dirToPosition();
							if(validPosition(u)&&Map.m1[u[0]][u[1]]==1&&Map.m2[u[0]][u[1]]==null) {
								card4.get(inputCard-1).walk(u);
								break;
							}
							if (validPosition(u)&&Map.m1[u[0]][u[1]]==4&&Map.m2[u[0]][u[1]]==null) {
								System.out.println("Choose a hole you want to appear: ");
								int indexXHole;
								int indexYHole;
								int[] newU=new int[2];
								do
								{
									System.out.print("Insert a row for your hole position: ");
									indexXHole=scan.nextInt();
									System.out.print("\nInsert a column for your hole position: ");
									indexYHole=scan.nextInt();
									newU[0]=indexXHole;
									newU[1]=indexYHole;
								}while(!(validPosition(newU)&&Map.m1[newU[0]][newU[1]]==4&&Map.m2[newU[0]][newU[1]]==null));
								card4.get(inputCard-1).walk(newU);
								break;
							}
									
						       
							
						}while(true);
						
						
					}
				
				}
				if(inputNum==2) {
					System.out.println(chaToName(card4.get(inputCard-1))+" ability!!");
					//Conan Gin ShadowMan Ran Kogoro Heiji 
					//card4.get(inputCard-1).ability();
					if(card4.get(inputCard-1) instanceof Conan) {
						card4.get(inputCard-1).ability();
					} else if(card4.get(inputCard-1) instanceof ShadowMan) {
						System.out.println("Choose a character you want to switch position with Shadow Man: ");
						Scas
						
					}
				}
				
			}
			
			
		
			
			card4.remove(inputCard-1);
			
		}
		
	}
	public static Character indexToCha(int index) {
		return allCharacter.get(index);
	} 
	public static String chaToName(Character character) {
		return indexToName(chaToIndex(character));
	}
	public static String indexToName(int index) {
		String name = null;
		if(index == 0) {
			name = "gin";
		}
		if(index == 1) {
			name = "shadowMan";
		}
		if(index == 2) {
			name = "conan";
		}
		if(index == 3) {
			name = "kogoro";
		}
		if(index == 4) {
			name = "heiji";
		}
		if(index == 5) {
			name = "ran";
		}
		if(index == 6) {
			name = "haibara";
		}
		if(index == 7) {
			name = "kid";
		}
		
		return name;
	}
	
	public static int chaToIndex(Character cha ) {
		int index = 0;
		if(cha instanceof Gin) {
			index = 0;
		}
		if(cha instanceof ShadowMan) {
			index = 1;
		}
		if(cha instanceof Conan) {
			index = 2;
		}
		if(cha instanceof Kogoro) {
			index = 3;
		}
		if(cha instanceof Heiji) {
			index = 4;
		}
		if(cha instanceof Ran) {
			index = 5;
		}
		if(cha instanceof Haibara) {
			index = 6;
		}
		if(cha instanceof Kid) {
			index = 7;
		}
		return index;
	}
	
	
}
