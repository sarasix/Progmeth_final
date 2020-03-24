package round;

import java.util.ArrayList;
import java.util.Scanner;

import character.Character;

public class Player {
private static ArrayList<Character> randomCard;
private int selectNumber; 
	
	public Player(ArrayList<Character> randomCard,int selectNumber) {
		this.selectNumber = selectNumber;
		this.randomCard = randomCard;
		
		selectCharacter();
		
		this.randomCard.remove(this.selectNumber);
	}
	
	public static ArrayList<Character> getRandomCard() {
		return randomCard;
	}
	
	public void selectCharacter() {
		Scanner scan = new Scanner (System.in);
	
		Character selectCard = randomCard.get(this.selectNumber);
		
		int walk = 1;
		System.out.println("Select to do\n1. walk\n2. ablity");
		walk = scan.nextInt();
		if(walk ==1) {
			System.out.println("walk");
			//selectCard.walk();
			
		}
		else {
			//selectCard.ability();
			System.out.println("ability");
		}
		
		
	}


}
