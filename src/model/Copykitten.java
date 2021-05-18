package model;

public class Copykitten extends Tactic {
	
	private static String Name = "Copykitten";
	private Move[] opp_last_moves;
	private static String ImgSrc = "src\\view\\copykitten.png";
	public String get_ImgSrc() {return ImgSrc;}

	public Copykitten() {
		opp_last_moves= new Move[] {Move.cooperate, Move.cooperate};
	}
	public Copykitten(Tactic a)
	{
		super(a);
		opp_last_moves= new Move[] {Move.cooperate, Move.cooperate};
	}
	public Move[] get_opp_last_moves() {return opp_last_moves;}
	public String get_Name () {return Name;}
	public Move choose() {
		if (opp_last_moves[0] == Move.cheat && opp_last_moves[1] == Move.cheat)
			return Move.cheat;
		return Move.cooperate;	
	}
	public Tactic copy() {
		return new Copykitten();
	}
	public void end_of_turn(Move my_last_move, Move opp_last_move, int a) {
		opp_last_moves[0] = opp_last_moves[1];
		opp_last_moves[1] = opp_last_move;
		coins += a;
	}
	public void end_of_match() {
		opp_last_moves[0] = Move.cooperate;
		opp_last_moves[1] = Move.cooperate;}

}
