package model;

public class Grudger extends Tactic {
	
	private static String Name = "Grudger";
	private static String ImgSrc = "src\\view\\grudger.png";
	private boolean has_been_cheated;
	public String get_Name () {return Name;}
	public String get_ImgSrc() {return ImgSrc;}
	public Grudger(Tactic a) {super(a);}
	public Grudger() {}
	public Move choose() {
		if(has_been_cheated)
			return Move.cheat;
		return Move.cooperate;
	}
	public Tactic copy() {
		return new Grudger();
	}
	public void reset() {
		coins = 0 ;
		has_been_cheated = false;
	}
	public void end_of_turn(Move my_last_move, Move opp_last_move, int a) {
		if(opp_last_move == Move.cheat)
			has_been_cheated = true;
		coins +=a;
	}
	public void end_of_match() {has_been_cheated = false;}
}
