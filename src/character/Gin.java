package character;

public class Gin extends Character implements Walk{
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
    public int[] walk(int dir) {
		int indexX=this.getIndexX();
		int indexY=this.getIndexY();
		int[] k = new int[2];
		//1left 2right 3up 4down
		if(dir == 1) {
			k[0]=indexX-1;
			k[1]=indexY;
			
			
		} else if (dir==2) {
			k[0]=indexX+1;
			k[1]=indexY;
			
		} else if (dir==3) {
			k[0]=indexX;
			k[1]=indexY-1;
		} else if (dir==4) {
			k[0]=indexX;
			k[1]=indexY+1;
		}
		return k;
	}
}
