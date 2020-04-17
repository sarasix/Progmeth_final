package initial;
import java.util.*;

import item.*;
import map.PutMap;
import map.Map;
import character.*;
import character.Character;
public class Initial  {
	
	public static int[][] m1  = new int[][]
										{ {5,1,1,1,1,4,1,1,1,1,1,1,5},
										{1,1,3,1,1,3,1,2,1,4,3,1,1},
										{1,2,2,1,1,2,1,3,1,1,1,1,1},
										{1,4,1,2,1,4,1,4,1,2,2,4,1},	
										{1,1,1,1,1,3,1,2,1,1,3,1,1},
										{1,3,1,4,1,1,1,3,1,1,1,1,1},
										{5,1,1,1,1,1,1,4,1,1,1,1,5}
									  };
	public static PutMap[][] m2 = new PutMap[7][13];  
	
	public Map mapAll = new Map(m1,m2);
											
	public int[][] lawRemoveItem = new int[][]{{8,3,5},
											   {7,3,5},
											   {6,3,4},
											   {5,2,4},
											   {4,2,3},
											   {3,2,3},
											   {3,1,2},
											   {3,1,2}
			
											  };

	public ArrayList<Integer> choice = new ArrayList<Integer>();
											  
	public ArrayList<String> order1 = new ArrayList<String> ();
	public ArrayList<String> order2 = new ArrayList<String> ();
	
	public ArrayList<Character> allCharacter = new ArrayList<Character>();
	

								
	public ArrayList<Lamp> allLamp  = new ArrayList <Lamp>();
	public ArrayList<ExitBarricade> allExitBarricade = new ArrayList<ExitBarricade>();
	public ArrayList<HoleCover> allHoleCover = new ArrayList<HoleCover>();
	
	Lamp lamp0 = new Lamp(1,2,0); 
	Lamp lamp1 = new Lamp(1,5,1);
	Lamp lamp2 = new Lamp(1,10,2);
	Lamp lamp3 = new Lamp(2,7,3);
	Lamp lamp4 = new Lamp(5,1,4);
	Lamp lamp5 = new Lamp(4,5,5);
	Lamp lamp6 = new Lamp(4,10,6);
	Lamp lamp7 = new Lamp(5,7,7);
    //parameter/ delete lamp blablabla	
	ExitBarricade exitBarricade0 = new ExitBarricade(0,0,0);
	ExitBarricade exitBarricade1 = new ExitBarricade(0,12,1);
	ExitBarricade exitBarricade2 = new ExitBarricade(6,0,2);
	
	HoleCover holeCover0 = new HoleCover(3,1,0);
	HoleCover holeCover1 = new HoleCover(3,5,1);
	HoleCover holeCover2 = new HoleCover(3,7,2);
	HoleCover holeCover3 = new HoleCover(3,11,3);
	HoleCover holeCover4 = new HoleCover(1,9,4);
	
	Gin gin = new Gin(0,3,true);
	ShadowMan shadowMan = new ShadowMan(4,2,true);
	Conan conan = new Conan(4,4,true);
	Kogoro kogoro = new Kogoro(1,6,true);
	Heiji heiji = new Heiji(5,6,true);
	Ran ran = new Ran(3,8,true);
	Haibara haibara = new Haibara(2,4,true);
	Kid kid = new Kid (4,9,true);
	
	public int getLawRemoveItem(int round,int item) {
		return this.lawRemoveItem[round][item];
	}
	
	
	public ArrayList<String> getOrder1(){
		return this.order1;
	}
	public ArrayList<String> getOrder2(){
		return this.order2;
	}
	
	
	
	public ArrayList<Lamp> getAllLamp (){
		return this.allLamp;
	}
	public ArrayList<ExitBarricade> getAllExitBarricade (){
		return this.allExitBarricade;
	}
	public ArrayList<HoleCover> getAllHoleCover (){
		return this.allHoleCover;
	}
	public void setCharactor() {
		m2[0][3] = gin;
		m2[4][2] = shadowMan;
		m2[4][4] = conan;
		m2[1][6] = kogoro;
		m2[5][6] = heiji;
		m2[3][8] = ran;
		m2[2][4] = haibara;
		m2[4][9] = kid;
		allCharacter.add(gin);
		allCharacter.add(shadowMan);
		allCharacter.add(conan);
		allCharacter.add(kogoro);
		allCharacter.add(heiji);
		allCharacter.add(ran);
		allCharacter.add(haibara);
		allCharacter.add(kid);
		
		
	}
	public void setOrder() {
		order1.add("D");
		order1.add("J");
		order1.add("J");
		order1.add("D");
		
		order2.add("J");
		order2.add("D");
		order2.add("D");
		order2.add("J");
	}

	public Map getMap() {
		Map mapAll = new Map(m1,m2);
		return mapAll;
	}
	public void setChoice() {
		for(int i =0 ; i<8;i++)
		{
			choice.add(1);
		}
		
	}
	public ArrayList <Integer> getChoice() {
		return choice;
	}
	public ArrayList<Character> getAllCharacter() {
		return this.allCharacter;
	}
	public Initial() {
		allLamp.add(lamp0);
		allLamp.add(lamp1);
		allLamp.add(lamp2);
		allLamp.add(lamp3);
		allLamp.add(lamp4);
		allLamp.add(lamp5);
		allLamp.add(lamp6);
		allLamp.add(lamp7);
		allExitBarricade.add(exitBarricade0);
		allExitBarricade.add(exitBarricade1);
		allExitBarricade.add(exitBarricade2);
		allHoleCover.add(holeCover0);
		allHoleCover.add(holeCover1);
		allHoleCover.add(holeCover2);
		allHoleCover.add(holeCover3);
		allHoleCover.add(holeCover4);
		setCharactor();
		setOrder();
		setChoice();
		
		
		
		
	}
		
	
}
