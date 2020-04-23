package main;
import initial.*;
import item.*;
import javafx.scene.image.ImageView;

import java.util.*;

import com.sun.scenario.effect.ColorAdjust;

import character.*;
import character.Character;
import map.Map;
import resloader.Resloader;
import view.GamePlay;


public class Main {
	public static Initial initial = new Initial();	
	public static ArrayList<Integer> choice = initial.getChoice();
	public static ArrayList<String> order1 = initial.getOrder1();
	public static ArrayList<String> order2 = initial.getOrder2();
	public static ArrayList<String> order = new ArrayList<String>();
	public static Map map = initial.getMap();
	public static Character CharacterNow;
	public static Character CharacterOther;
	public static ArrayList<Character> allCharacter = initial.getAllCharacter();
	public static ArrayList<Character> choiceCharacter = new ArrayList<Character>();
	
	public static int dir;		
	public static int step;
	public static int inputCard;
	public static Item itemChosen;
	public static ArrayList<Character> card4 = new ArrayList<Character>();
	public static int[] indexItemField=new int[2];
	
	public static Random rand = new Random();
	public static Scanner scan = new Scanner(System.in);	
	private static int randomNumber;
	
	public static Character MrJack;
	public static boolean gameWin = false;
	
	
	/*public static void main(String[] arg) {
		start();
	
	}*/
	public static void start() {
		System.out.println("start");
		randomNumber = rand.nextInt(8);
		MrJack = allCharacter.get(randomNumber);
		
		GamePlay.createOverlabSubScane( new ImageView (Resloader.buttonPlay),GamePlay.indexToIVCard(randomNumber));
	
		System.out.println("MrJack is "+chaToName(MrJack));
		MrJack.setIsMrJack(true);
		
		GamePlay.chaSel = new ArrayList<Integer> ();
		//loopRound();
			
	}
	
	public static void loopRound (){
		for(int i=0;i<1;i++) { // แก้กลับเป็น  8 ด้วย 
			if(gameWin==true) {
				break;
			}
			System.out.println("round"+(i+1));
			if(i%2 == 0) {
				order = order1;
			}
			else {
				order = order2;
			}
			
			
			//
			//แก้ให้มันอยู๋ตรงกลาง + เปลี่ยนเป็นตัวเลข
			//
			int numLamp = initial.getLawRemoveItem(i,0);
			int numExitBarricade = initial.getLawRemoveItem(i,1) ;
			int numHoleCover = initial.getLawRemoveItem(i,2);
			
			removeItem(numLamp,numExitBarricade,numHoleCover);
			randomCard();
			//play();
			isLight();
			//isChoice();
			
		}

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
		int[] card4Index = new int[4]; 
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
			card4Index[i] = randomNumber;
			card4.add(allCharacter.get(randomNumber));
		}	
		GamePlay.round++;
		GamePlay.createCard4(new ImageView(Resloader.blue),card4Index[0],card4Index[1],card4Index[2],card4Index[3]);
			
			
	}
	public static boolean validPosition(int[] pos) {
		if(pos[0]>=0&&pos[0]<=6&&pos[1]>=0&&pos[1]<=12) {
			return true;
		}
		return false;
	}
    public static int[] dirToPosition(Character Ch) {
    	int[] k = new int[2];
    	if(dir == 1) {
			k[0]=Ch.getIndexX();
			k[1]=Ch.getIndexY()-1;
			
			
		} else if (dir==2) {
			k[0]=Ch.getIndexX();
			k[1]=Ch.getIndexY()+1;
			
			
		} else if (dir==3) {
			k[0]=Ch.getIndexX()-1;
			k[1]=Ch.getIndexY();
		} else if (dir==4) {
			k[0]=Ch.getIndexX()+1;
			k[1]=Ch.getIndexY();
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
			CharacterNow=card4.get(inputCard-1);
			if(CharacterNow instanceof Haibara || CharacterNow instanceof Kid) {
				do {
					System.out.println("How many steps you want to walk? Maximum: "+CharacterNow.getWalk());
					step=scan.nextInt();
				}while(!(step>=1&&step<=CharacterNow.getWalk()));
				for(int j=1;j<=step;j++) {
					
					do
					{
						
						do
						{
							System.out.println("step"+j+"Please insert walk direction : [1]<- [2]-> [3]^ [4]v");
							dir= scan.nextInt();
						}while(!(dir<=4&&dir>=1));
						
						u=dirToPosition(CharacterNow);
						if(validPosition(u)&&Map.m1[u[0]][u[1]]==1&&Map.m2[u[0]][u[1]]==null) {
							CharacterNow.walk(u);
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
							CharacterNow.walk(newU);
							
							break;
						}
								
					       
						
					}while(true);
					
					
				}
				if(CharacterNow instanceof Haibara) {
					int j;
					do
					{
						System.out.println("Choose the direction for your Haibara's Light: [1]<- [2]-> [3] ^  [4] v");
						j=scan.nextInt();
					}while(!(j>=1&&j<=4));
					((Haibara) CharacterNow).setDirectionLight(j);
				}
				
				
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
						System.out.println("How many steps you want to walk? Maximum: "+CharacterNow.getWalk());
						step=scan.nextInt();
					}while(!(step>=1&&step<=CharacterNow.getWalk()));
					for(int j=1;j<=step;j++) {
						
						do
						{
							
							do
							{
								System.out.println("step"+j+"Please insert walk direction : [1]<- [2]-> [3]^ [4]v");
								dir= scan.nextInt();
							}while(!(dir<=4&&dir>=1));
							
							u=dirToPosition(CharacterNow);
							if(validPosition(u)&&Map.m1[u[0]][u[1]]==1&&Map.m2[u[0]][u[1]]==null) {
								CharacterNow.walk(u);
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
								CharacterNow.walk(newU);
								break;
							}
									
						       
							
						}while(true);
						
						
					}
				
				}
				if(inputNum==2) {
					System.out.println(chaToName(card4.get(inputCard-1))+" ability!!");
					//Conan Gin ShadowMan Ran Kogoro Heiji 
					//card4.get(inputCard-1).ability();
					if(CharacterNow instanceof Conan) {
						CharacterNow.ability();
					} else if(CharacterNow instanceof ShadowMan) {
						System.out.println("Choose a character you want to switch position with Shadow Man: ");
						int indexCha;
						do
						{
							System.out.println("[0]Gin");
							System.out.println("[2]Conan");
							System.out.println("[3]Kogoro");
							System.out.println("[4]Heiji");
							System.out.println("[5]Ran");
							System.out.println("[6]Haibara");
							System.out.println("[7]Kid");
							indexCha=scan.nextInt();
						}while(!(indexCha==0||indexCha==2||indexCha==3||indexCha==4||indexCha==5||indexCha==6||indexCha==7));
						CharacterOther=indexToCha(indexCha);
						CharacterNow.ability();
						
						
					} else if (CharacterNow instanceof Gin) {
						System.out.println("Choose a character you want to walk: ");
						int indexCha;
						do
						{
							System.out.println("[0]Gin");
							System.out.println("[1]ShadowMan");
							System.out.println("[2]Conan");
							System.out.println("[3]Kogoro");
							System.out.println("[4]Heiji");
							System.out.println("[5]Ran");
							System.out.println("[6]Haibara");
							System.out.println("[7]Kid");
							indexCha=scan.nextInt();
						}while(!(indexCha<=7&&indexCha>=0));
						CharacterOther=indexToCha(indexCha);
						do {
							System.out.println("How many steps you want to walk? Maximum: "+CharacterOther.getWalk());
							step=scan.nextInt();
						}while(!(step>=1&&step<=CharacterOther.getWalk()));
						for(int j=1;j<=step;j++) {
							
							do
							{
								
								do
								{
									System.out.println("step"+j+"Please insert walk direction : [1]<- [2]-> [3]^ [4]v");
									dir= scan.nextInt();
								}while(!(dir<=4&&dir>=1));
								
								u=dirToPosition(CharacterOther);
								if(validPosition(u)&&Map.m1[u[0]][u[1]]==1&&Map.m2[u[0]][u[1]]==null) {
									CharacterOther.walk(u);
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
									CharacterOther.walk(newU);
									break;
								}
										
							       
								
							}while(true);
							
							
						}	
						
					}
					else if(CharacterNow instanceof Heiji || CharacterNow instanceof Kogoro || CharacterNow instanceof Ran) {
						int getItem;
						if(CharacterNow instanceof Heiji) {
							do 
							{
								System.out.println("Choose a hole cover");
								
								for(int j=0;j<Map.allHoleCover.size();j++) {
									System.out.println("["+j+"] HoleCover"+Map.allHoleCover.get(j).getNumber());
								
								}
								getItem=scan.nextInt();
							}while(!(getItem>=0&&getItem<Map.allHoleCover.size()));
						    itemChosen=Map.allHoleCover.get(getItem);
						}
						if(CharacterNow instanceof Ran) {
							do 
							{
								System.out.println("Choose an exit barricade");
								
								for(int j=0;j<Map.allExitBarricade.size();j++) {
									System.out.println("["+j+"] ExitBarricade"+Map.allExitBarricade.get(j).getNumber());
								
								}
								getItem=scan.nextInt();
							}while(!(getItem>=0&&getItem<Map.allExitBarricade.size()));
						    itemChosen=Map.allExitBarricade.get(getItem);
						}
						if(CharacterNow instanceof Kogoro) {
							do 
							{
								System.out.println("Choose a lamp");
								
								for(int j=0;j<Map.allLamp.size();j++) {
									System.out.println("["+j+"] Lamp"+Map.allLamp.get(j).getNumber());
								
								}
								getItem=scan.nextInt();
							}while(!(getItem>=0&&getItem<Map.allLamp.size()));
						    itemChosen=Map.allLamp.get(getItem);
						}
						do 
						{
							System.out.println("Choose a suitable field you want to place this item on");
							System.out.print("Insert a row of position: ");
							indexItemField[0]=scan.nextInt();
							System.out.print("\nInsert a column of position: ");
							indexItemField[1]=scan.nextInt();
							
						}while(!(validPosition(indexItemField)&&Map.m1[indexItemField[0]][indexItemField[1]]==itemChosen.getTypeField()&&Map.m2[indexItemField[0]][indexItemField[1]]==null));
						CharacterNow.ability();
						
					}
				}
				
			}
			
			
		
			
			card4.remove(inputCard-1);
			
		}
		
	}
	public static void walk() {
		
		Character c = indexToCha ( GamePlay.cha);
		int[] u= new int[2];
		u[0] = c.getIndexX()+GamePlay.dir1;
		u[1] = c.getIndexY()+GamePlay.dir2;
		if(validPosition(u)&&Map.m1[u[0]][u[1]]==1&&Map.m2[u[0]][u[1]]==null) {
			
			GamePlay.indexToIVBoard(GamePlay.cha).setX(148+66*u[1]);
			GamePlay.indexToIVBoard(GamePlay.cha).setY(100+66*u[0]);	
			
			c.walk(u);
			GamePlay.walk++;
			
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
			CharacterNow.walk(newU);
			
		}
	}
	public static void isLight () {
		for(int index = 0; index < 8; index++ ) {
			
			Character character = allCharacter.get(index);
			int x = character.getIndexX();
			int y = character.getIndexY();
			int light = 0;
			for(int i = x-1 ;i<= x+1 ; i++ ) {
				for(int j = y-1 ; j<= y+1 ; j++ ) {
					int[] pos = new int [] {i,j};
					if( validPosition(pos)){
						if (Map.m2[i][j] instanceof Lamp) {
							allCharacter.get(index).setIsLight(true);
							light = 1;
							break;
						}
					
					}
				}
				if(light ==1 ) {
					break;
				}
			}
			//int ix = allCharacter.get(6).getIndexX();
			//int iy = allCharacter.get(6).getIndexX();
			//int dir = ((Haibara) allCharacter.get(6)).getDirectionLight();
			
			if(light == 0) {
				allCharacter.get(index).setIsLight(false);
				
			}
		}
		for (int i=0;i<8;i++) {
			if(allCharacter.get(i).getIsLight()==true) {
				System.out.print("["+chaToName(allCharacter.get(i))+" "+"light"+"] ");
				
			}
			
			if(allCharacter.get(i).getIsLight()==true) {
				System.out.print("["+chaToName(allCharacter.get(i))+" "+"dark"+"] ");
				
			}
		}
		System.out.println();
		//เพิ่ม set ใน walk
	}
	
	public static void isChoice() {
		System.out.print("Now Jack is in ");
		boolean light = true;
		if(MrJack.getIsLight()) {
			light = true;
			System.out.println("light!!");
			
		}
		else {
			light = false;
			System.out.println("dark!!");
			
		}
		
		for(int i =0; i <8; i++) {
			if(allCharacter.get(i).getIsChoice()) {
				if(allCharacter.get(i).getIsLight()!=light) {
						allCharacter.get(i).setIsChoice(false);
				}				
			}
		}
		System.out.println("====In Choice====");
		choiceCharacter = new ArrayList<Character>();
		int c = 0;
		for(int i =0 ; i <8; i++) {
			if(allCharacter.get(i).getIsChoice()) {
				c++;
				System.out.println("["+(c)+"]"+chaToName(allCharacter.get(i))+" ");
				choiceCharacter.add(allCharacter.get(i));
			}
		}
		c = 0;
		for(int i =0 ; i <8; i++) {
			if(!allCharacter.get(i).getIsChoice()) {
				
				ColorAdjust shadow = new ColorAdjust();
				shadow.setBrightness(-1);
				GamePlay.isChoice.get(i).setEffect(shadow);
			}
		}
		
		
		System.out.println("Do you want to investigate now [1]yes [2]no");
		//int inputNumber = scan.nextInt();
		int inputNumber = 0;
		c = 0;
		if(inputNumber ==1) {
			System.out.println("Who is Jack");
			for(int i =0 ; i <8; i++) {
				if(allCharacter.get(i).getIsChoice()) {
					c++;
					System.out.println("["+(c)+"]"+chaToName(allCharacter.get(i))+" ");			
				}
			}
			inputNumber = scan.nextInt();
			if(choiceCharacter.get(inputNumber-1) == MrJack) {
				System.out.println("Detective Win!!!!");
			}
			else {
				System.out.println("MrJack Win!!!!");
			}
			gameWin = true;
			
			
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
