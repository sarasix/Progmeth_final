package round;
import java.util.*;

import character.Character;
import character.Conan;
import round.PlayDetective;
import round.PlayMrJack;
public class Round {
	private int lamp,manhole,door ;
	private ArrayList<String> order;
	public ArrayList<Character> card4;
	public static ArrayList<Character> allCharactor;
	public int[] light ;
	public int[] choice; 
	public int n;
	public Round(int lamp,int manhole,int door,ArrayList<String> order,ArrayList<Integer> choice) 
	{
		this.lamp = lamp;
		this.manhole = manhole;
		this.door = door;
		this.order = order;
		
	}
	public void removeLamp() {
		
	}
	public void random() {
		for(int i = 0; i<4 ; i++)
		{
			while(true)
			{
				Random rand = new Random();
				n =   rand.nextInt(8);
				
				if(!card4.contains(this.allCharactor.get(n))) {
					break;
				}
			}
			
			
			
			this.card4.add(this.allCharactor.get( n ));
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
		for (var i : allCharactor) { // �纵���Ф÷�����
			
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
	public int chaToIndex(Character cha ) {
		if(cha instanceof Conan) {
			n = 2;
		}	
		return n;
	}
	public void remove(int index) {
		//this.choice[index] = 0;
		this.allCharactor.get(index).setIsChoice(false);
		
	}
	public static Character indexToCha(int index) {
		return allCharactor.get(index);
	}
	
	
	
}
