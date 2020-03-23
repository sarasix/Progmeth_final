package round;

import java.util.ArrayList;

import character.Character;

public class PlayMrJack {
private ArrayList<Character> randomCard;
	
	public ArrayList<Character> playMrJack(ArrayList<Character> card4) {
		 int n = getCharactor(card4);
		 randomCard.remove(n);
		 return randomCard;
		// TODO Auto-generated constructor stub
	}
	public int getCharactor(ArrayList< Character> randomCard) {
		System.out.println("playDe");
		this.randomCard = randomCard;
		int n = 1;
		select(n);
		
		return  n;
		
	}
	public void select(int i) {
		Character selectCard = randomCard.get(i);
		int walk = 1;
		if(walk ==1) {
			selectCard.walk();
			
		}
		else {
			selectCard.ability();
		}
		
		
	}

}
