package character;

public class Gin extends Character{
	private int walk;
	public Gin(int indexX,int indexY,boolean isLight) {
		super(indexX,indexY,isLight);
		walk=3;
	}
    public boolean ability() {
    	//เรียกตัวละครให้เข้าใกล้ได้ 1-3 ช่อง
    	return true;
    }
    public int getWalk() {
    	return walk;
    }
}
