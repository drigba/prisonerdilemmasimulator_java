package model;

public class Simpleton extends Tactic {
	
	private static String Name = "Simpleton";
	private Move opp_last_move;
	private Move my_last_move;
	private static String ImgSrc = "src\\view\\simpleton.jpg";
	
	public Simpleton(Tactic a) {super(a);}

	public Simpleton() {
		opp_last_move = Move.cooperate;
		my_last_move = Move.cooperate;
	}
	public String get_Name () {return Name;}
	public String get_ImgSrc() {
		return ImgSrc;
	}
	public Move get_my_last_move() {
		return my_last_move;
		
	}
	

	public Tactic copy() {return new Simpleton();}

	public Move choose() {
		if (opp_last_move == Move.cheat) {
			my_last_move = my_last_move.negate();
		}
		return my_last_move; 
	}

	public void end_of_turn(Move my_last_move, Move opp_last_move, int a) {
		this.my_last_move = my_last_move;
		this.opp_last_move = opp_last_move;
		coins += a;
	}

	public void end_of_match() {
		opp_last_move = Move.cooperate;
		my_last_move = Move.cooperate;
	}
}
