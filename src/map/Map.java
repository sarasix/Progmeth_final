package map;

public class Map {
	public int[][] m1;
	public PutMap[][] m2;
	public Map(int[][] m1,PutMap[][]m2) {
		
		this.m1 = m1;
		this.m2 = m2;
		
		
	}
	public int getM1(int indexX,int indexY) {
		return m1[indexX][indexY];
	}
	public PutMap getM2(int indexX,int indexY) {
		return m2[indexX][indexY];
	}
	public void setM2(PutMap g,PutMap t) {
		g=t;
		
	}
	
}
