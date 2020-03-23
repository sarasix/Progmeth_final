package round;

import java.util.ArrayList;

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
		Character selectCard = randomCard.get(this.selectNumber);
		int walk = 1;
		if(walk ==1) {
			selectCard.walk();
			
		}
		else {
			selectCard.ability();
		}
		
		
	}


}
