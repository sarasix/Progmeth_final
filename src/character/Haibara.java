package character;

public class Haibara extends Character {

	private int directionLight;

	public Haibara(int indexX, int indexY, boolean isLight) {
		super(indexX, indexY, isLight, 3);
		this.directionLight = 0;
	}

	public void setDirectionLight(int h) {
		this.directionLight = h;
	}

	public int getDirectionLight() {
		return this.directionLight;
	}

}
