package character;

public class Haibara extends Character{
	private int walk;
	public Haibara(int indexX,int indexY,boolean isLight) {
		super(indexX,indexY,isLight);
		this.walk=3;
	}
	public boolean ability()
	{
		//��ͧ�ʧ价���˹����
		return true;
		
	}
	public int getWalk() {
		return this.walk;
	}

}
