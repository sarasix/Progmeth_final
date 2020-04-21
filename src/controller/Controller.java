package controller;

import initial.Initial;
import main.Main;

public class Controller {
	public static int order = 0;
	public static int round = 0;
	
	public static Initial initial = Main.initial;
	
	public static void start() {
		Main.start();
	}
	public static void loopRound() {
		
		
	}
	public static void setRound() {
		int numLamp = initial.getLawRemoveItem(round,0);
		int numExitBarricade = initial.getLawRemoveItem(round,1) ;
		int numHoleCover = initial.getLawRemoveItem(round,2);
		
		Main.removeItem(numLamp,numExitBarricade,numHoleCover);
		Main.randomCard();
		//play();
		Main.isLight();
		
		order = 2;
		
	}
	public static void card4() {
		
		
		
		
	}
	
	
	
}
