package character;

public class Gin extends Character{
	private int walk;
	public Gin(int indexX,int indexY,boolean isLight) {
		super(indexX,indexY,isLight);
		walk=3;
	}
    public void ability() {
    	//���¡����Ф������������ 1-3 ��ͧ
    }
    public int getWalk() {
    	return walk;
    }
}
