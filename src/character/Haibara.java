package character;

public class Haibara extends Character{
	private int walk;
	public Haibara(int indexX,int indexY,boolean isLight) {
		super(indexX,indexY,isLight);
		this.walk=3;
	}
	public void ability()
	{
		//��ͧ�ʧ价���˹����
		
	}
	public int getWalk() {
		return this.walk;
	}

}
