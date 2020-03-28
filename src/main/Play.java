package main;
import initial.*;
import item.*;
import round.*;
import java.util.*;
import map.Map;

public class Play {
	public static ArrayList<Round> game = new ArrayList<Round> ();
	public static Initial initial = new Initial();	
	public static ArrayList<Integer> choice = initial.getChoice();
	public static ArrayList<String> order1 = initial.getOrder1();
	public static ArrayList<String> order2 = initial.getOrder2();
	public static ArrayList<String> order = new ArrayList<String>();
	public static Map map = initial.getMap();
	//public static ArrayList<Lamp> allLamp = initial.getAllLamp();
	//public static ArrayList<ExitBarricade> allExitBarricade = initial.getAllExitBarricade();
	//public static ArrayList<HoleCover> allHoleCovers = initial.getAllHoleCover();

	
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
			Round roundCurrent = new Round(initial.getLawRemoveItem(i,0),initial.getLawRemoveItem(i,1) , initial.getLawRemoveItem(i,2),order,choice,map);
			map = roundCurrent.getMap();
			game.add(roundCurrent);
		}

			}
}
