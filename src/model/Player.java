package model;

public class Player extends Tactic {

	public Player() {
		nextMove= Move.cooperate;
		
		
	}
	
	public Move choose() {
		return nextMove;
	}

	public Tactic copy() {
		return this;
		
	}

}
