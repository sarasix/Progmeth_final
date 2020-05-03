package character;

public abstract class CharacterWithAbility extends Character {

	public CharacterWithAbility(int indexX, int indexY, boolean isLight, int walk) {
		super(indexX, indexY, isLight, walk);

	}

	public abstract void ability();

}
