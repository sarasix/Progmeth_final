package map;

import java.util.ArrayList;

import item.ExitBarricade;
import item.HoleCover;
import item.Lamp;
import initial.*;

public class Map {
	public static int[][] m1;
	public static PutMap[][] m2;
	public static Initial initial = new Initial();
	public static ArrayList<Lamp> allLamp = initial.getAllLamp();
	public static ArrayList<ExitBarricade> allExitBarricade = initial.getAllExitBarricade();
	public static ArrayList<HoleCover> allHoleCover = initial.getAllHoleCover();

	public Map(int[][] m1, PutMap[][] m2) {

		Map.m1 = m1;
		Map.m2 = m2;

	}

	public int getM1(int i, int j) {
		return m1[i][j];
	}

	public PutMap getM2(int i, int j) {
		return m2[i][j];
	}

	public void setM2(int i, int j, PutMap item) {
		m2[i][j] = item;

	}

	public static ArrayList<Lamp> getAllLamp() {
		return allLamp;
	}

	public static ArrayList<ExitBarricade> getAllExitBarricade() {
		return allExitBarricade;
	}

	public static ArrayList<HoleCover> getAllHoleCover() {
		return allHoleCover;
	}

	public void setAllLamp(ArrayList<Lamp> newAllLamp) {
		allLamp = newAllLamp;
	}

	public void setAllExitBarricade(ArrayList<ExitBarricade> newAllExitBarricade) {
		allExitBarricade = newAllExitBarricade;
	}

	public void setAllHoleCover(ArrayList<HoleCover> newAllHoleCover) {
		allHoleCover = newAllHoleCover;
	}

}
