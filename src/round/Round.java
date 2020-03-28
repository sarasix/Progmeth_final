package round;
import java.util.*;
import item.*;
import map.Map;

import character.*;
import character.Character;
import round.PlayDetective;
import round.PlayMrJack;
public class Round {
	private int numLamp,numExitBarricade,numHoleCover ;
	private ArrayList<String> order;
	public ArrayList<Character> card4;
	public static ArrayList<Character> allCharactor;
	public int[] light ;
	public int[] choice; 
	public int n;
	public Map map;
	public Round(int numLamp,int numExitBarricade,int numHoleCover,ArrayList<String> order,ArrayList<Integer> choice,Map map) 
	{
		this.numLamp = numLamp;
		this.numExitBarricade = numExitBarricade;
		this.numHoleCover = numHoleCover;
		this.order = order;
		this.map = map;
		removeItem();
		printMap();
		//random();	
		
	}
	public void printMap() {
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
			System.out.print("\n");
		}			
	}
	public void removeItem() {
		
		if (map.getAllLamp().size() > numLamp) {
			Random rand = new Random();
			n =   rand.nextInt(map.getAllLamp().size());
			System.out.println("Lamp remove!!");
			this.map.setM2(map.getAllLamp().get(n).getIndexX(), map.getAllLamp().get(n).getIndexY(), null);
			ArrayList<Lamp> newAllLamp = map.getAllLamp();
			newAllLamp.remove(n);
			this.map.setAllLamp(newAllLamp);
		}
		if (map.getAllExitBarricade().size() > numExitBarricade) {
			Random rand = new Random();
			n =   rand.nextInt(map.getAllExitBarricade().size());
			System.out.println("ExitBarricade remove!!");
			map.setM2(map.getAllExitBarricade().get(n).getIndexX(), map.getAllExitBarricade().get(n).getIndexY(), null);
			ArrayList<ExitBarricade> newAllExitBarricade = map.getAllExitBarricade();
			newAllExitBarricade.remove(n);
			map.setAllExitBarricade(newAllExitBarricade);
		}if (map.getAllHoleCover().size() > numHoleCover) {
			Random rand = new Random();
			n =   rand.nextInt(map.getAllHoleCover().size());
			System.out.println("HoleCover remove!!");
			map.setM2(map.getAllHoleCover().get(n).getIndexX(), map.getAllHoleCover().get(n).getIndexY(), null);
			ArrayList<HoleCover> newAllHoleCover = map.getAllHoleCover();
			newAllHoleCover.remove(n);
			map.setAllHoleCover(newAllHoleCover);
		}
		
	}
	public void random() {
		for(int i = 0; i<4 ; i++)
		{
			while(true)
			{
				Random rand = new Random();
				n =   rand.nextInt(8);
				
				if(!this.card4.isEmpty()) {
					if(!card4.contains(allCharactor.get(n))) {
						break;	
					}
				}
			}
			this.card4.add(allCharactor.get( n ));
		}		
		for(int i=0 ;i<4;i++) {			
			System.out.println(chaToIndex(card4.get(i)));
		}
	}
	
	public void play() {
		ArrayList<Character> randomCard  = card4;
		for(int i=0;i<4;i++) {
			if(order.get(i)=="D") {
				System.out.println("Detective");
				}
			else {
				System.out.println("MrJack");
			}
			System.out.println("Please select card");
			Player player = new Player(randomCard,0);
		
			randomCard = Player.getRandomCard();
		}
	}
	
	public void islight() {
		int c = 0;
		for (var i : allCharactor) { // เก็บตัวละครทั้งหมด
			
			if(i.getIsLight()){
				light[c] = 1;
			}
			else {
				light[c] = 0;
			}
			c++;
		}
		
		
	}
	public void editChoice() {
		for(var i : this.allCharactor) {
			if(!i.getIsChoice()) {
				this.choice[chaToIndex(i)] = 0 ;
			}
		}
		
	}
	
	public void guessJack(int x) {
		if(x == 1) {
			
			
		}
		
	}
	
	public void remove(int index) {
		//this.choice[index] = 0;
		this.allCharactor.get(index).setIsChoice(false);
		
	}
	public static Character indexToCha(int index) {
		return allCharactor.get(index);
	}
	public int chaToIndex(Character cha ) {
		if(cha instanceof Gin) {
			n = 2;
		}
		if(cha instanceof ShadowMan) {
			n = 2;
		}
		if(cha instanceof Conan) {
			n = 2;
		}
		if(cha instanceof Kogoro) {
			n = 2;
		}
		if(cha instanceof Conan) {
			n = 2;
		}
		if(cha instanceof Conan) {
			n = 2;
		}
		if(cha instanceof Conan) {
			n = 2;
		}
		if(cha instanceof Conan) {
			n = 2;
		}
		return n;
	}
	public Map getMap() {
		return map;
	}
	
	
}
