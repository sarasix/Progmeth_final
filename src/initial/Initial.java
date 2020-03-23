package initial;
import java.util.*;

import item.*;
import map.putMap;
import round.Round;
import map.Map;
import character.*;
import character.ShadowMan;
public class Initial  {
	
	public int[][] m1  = new int [][] { {5,1,1,1,1,4,1,1,1,1,1,1,5},
										{1,1,3,1,1,3,1,2,1,4,3,1,1},
										{1,2,2,1,1,2,1,3,1,1,1,1,1},
										{1,4,1,2,1,4,1,4,1,2,2,4,1},	
										{1,1,1,1,1,3,1,2,1,1,3,1,1},
										{1,3,1,4,1,1,1,3,1,1,1,1,1},
										{5,1,1,1,1,1,1,4,1,1,1,1,5}
									  };
	public putMap[][] m2 = new putMap[][]  {{},
											{},
											{},
											{},
											{},
											{},
									 		{},
											};
											
	public int[][] lawRemoveItem = new int[][]{{8,5,3},
											   {7,5,3},
											   {6,4,3},
											   {5,4,2},
											   {4,3,2},
											   {3,3,2},
											   {3,2,1},
											   {3,2,1}
			
											  };

	public ArrayList<Integer> choice = new ArrayList<Integer>();
											  
	public ArrayList<String> order1 = new ArrayList<String> ();
	public ArrayList<String> order2 = new ArrayList<String> ();

								
	public ArrayList<Lamp> allLamp  = new ArrayList <Lamp>();
	public ArrayList<ExitBarricade> allExitBarricade = new ArrayList<ExitBarricade>();
	public ArrayList<HoleCover> allHoleCover = new ArrayList<HoleCover>();
	
	Lamp lamp0 = new Lamp(1,2); 
	Lamp lamp1 = new Lamp(1,5);
	Lamp lamp2 = new Lamp(1,10);
	Lamp lamp3 = new Lamp(2,7);
	Lamp lamp4 = new Lamp(5,1);
	Lamp lamp5 = new Lamp(4,5);
	Lamp lamp6 = new Lamp(4,10);
	Lamp lamp7 = new Lamp(5,7);
	
	ExitBarricade exitBarricade0 = new ExitBarricade(0,0);
	ExitBarricade exitBarricade1 = new ExitBarricade(0,12);
	ExitBarricade exitBarricade2 = new ExitBarricade(6,0);
	
	HoleCover holeCover0 = new HoleCover(3,1);
	HoleCover holeCover1 = new HoleCover(3,5);
	HoleCover holeCover2 = new HoleCover(3,7);
	HoleCover holeCover3 = new HoleCover(3,11);
	HoleCover holeCover4 = new HoleCover(1,9);
	
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
	
	public void setAllLamp(ArrayList<Lamp> allLamp,Lamp lamp) {
		this.allLamp.add(lamp);
		m2[lamp.getindexX][lamp.getindexY] = lamp;
	}
	public void setAllExitBarricade(ArrayList<ExitBarricade> allExitBarricade,ExitBarricade exitBarricade) {
		this.allExitBarricade.add(exitBarricade);
		m2[exitBarricade.getindexX][exitBarricade.getindexY] = exitBarricade;
	}
	public void setAllHoleCover(ArrayList<HoleCover> allHoleCover,HoleCover holeCover) {
		this.allHoleCover.add(holeCover);
		m2[holeCover.getindexX][holeCover.getindexY] = holeCover;
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
	public void setMap() {
		Map map = new Map(this.m1,this.m2);

	}
	public void setChoice() {
		int c = 0;
		for(var i : choice) {
			i = 1;
			if(c==7) {
				break;
			}
		}
	}
	public ArrayList <Integer> getChoice() {
		return choice;
	}
	
	public Initial() {
		setAllLamp(allLamp,lamp0);
		setAllLamp(allLamp,lamp1);
		setAllLamp(allLamp,lamp2);
		setAllLamp(allLamp,lamp3);
		setAllLamp(allLamp,lamp4);
		setAllLamp(allLamp,lamp5);
		setAllLamp(allLamp,lamp6);
		setAllLamp(allLamp,lamp7);
		setAllExitBarricade(allExitBarricade, exitBarricade0);
		setAllExitBarricade(allExitBarricade, exitBarricade1);
		setAllExitBarricade(allExitBarricade, exitBarricade2);
		setAllHoleCover(allHoleCover, holeCover0);
		setAllHoleCover(allHoleCover, holeCover1);
		setAllHoleCover(allHoleCover, holeCover2);
		setAllHoleCover(allHoleCover, holeCover3);
		setAllHoleCover(allHoleCover, holeCover4);
		setCharactor();
		setOrder();
		setMap();
		setChoice();
		
		
		
		
	}
		
	
}
