package main;
import initial.*;
import item.*;
import round.*;
import java.util.*;

import character.Character;
import character.Conan;
import character.Gin;
import character.Kogoro;
import character.ShadowMan;
import map.Map;

public class Main {
	public static Initial initial = new Initial();	
	public static ArrayList<Integer> choice = initial.getChoice();
	public static ArrayList<String> order1 = initial.getOrder1();
	public static ArrayList<String> order2 = initial.getOrder2();
	public static ArrayList<String> order = new ArrayList<String>();
	public static Map map = initial.getMap();
	public static ArrayList<Character> allCharacter = initial.getAllCharacter();
	static Random rand = new Random();
	private static int randomNumber;
	
	
	
	public static void main(String[] arg) {
		System.out.println("start");
		loopRound();
	
	}
	public static void loopRound (){
		for(int i=0;i<8;i++) {
			System.out.println("round"+i);
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
		printMap();
		
		
	}
	public static void printMap() {
		for(int i = 0 ; i< 7;i++) {
			for(int j = 0 ;j<13; j++) {				
				if(map.getM2(i,j) != null) {				
					if(map.getM2(i,j)instanceof Lamp) {
						System.out.print("l"+ " ");
					}
					else if(map.getM2(i,j)instanceof ExitBarricade) {
						System.out.print("E"+ " ");
					}
					else if(map.getM2(i,j)instanceof HoleCover) {
						System.out.print("H"+ " ");
					}
					else {
						System.out.print("*"+ " ");
					}					
				}
				else{
					System.out.print(map.getM1(i, j)+ " ");
				}
			}
			System.out.println("\n");
			
			
		}			
	}
	
	public static void removeItem(int numLamp,int numExitBarricade,int numHoleCover) {
		
		if (Map.allLamp.size() > numLamp) {
			
			randomNumber =   rand.nextInt(Map.allLamp.size());
			System.out.println("Lamp remove!!");
			Map.m2[Map.allLamp.get(randomNumber).getIndexX()][ Map.allLamp.get(randomNumber).getIndexY()] = 
			ArrayList<Lamp> newAllLamp = Map.getAllLamp();
			newAllLamp.remove(n);
		}
		if (Map.allLamp.size() > numLamp) {
				Random rand = new Random();
				n =   rand.nextInt(map.getAllLamp().size());
				System.out.println("Lamp remove!!");
				this.map.setM2(map.getAllLamp().get(n).getIndexX(), map.getAllLamp().get(n).getIndexY(), null);
				ArrayList<Lamp> newAllLamp = map.getAllLamp();
				newAllLamp.remove(n);
				this.map.setAllLamp(newAllLamp);
		}
			
	}
	
	
	
	
	
		public void editChoice() {
		for(var i : this.allCharactor) {
			if(!i.getIsChoice()) {
				this.choice[chaToIndex(i)] = 0 ;
			}
		}
		
	}
	public static Character indexToCha(int index) {
		return allCharactor.get(index);
	}
	public int chaToIndex(Character cha ) {
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
