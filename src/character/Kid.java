package character;

public class Kid extends Character implements Walk {

	public Kid(int indexX, int indexY, boolean isLight) {
		super(indexX, indexY, isLight, 5);
	}
}
