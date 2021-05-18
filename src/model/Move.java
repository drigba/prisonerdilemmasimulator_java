package model;

public enum Move {
	cooperate, cheat;
	
	public  Move negate()
	{
		if(this == cooperate)
			return cheat;
		return cooperate;
	}
}
