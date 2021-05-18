package model;



public class CopyCat extends Tactic{
	private Move opp_last_move;
	private static String ImgSrc = "src\\view\\copycat.jpg";
	private static String Name = "Copycat";
	public String get_Name () {return Name;}
	public String get_ImgSrc() {return ImgSrc;}
	public CopyCat(Tactic a) {
		super(a);
	}
	public CopyCat() {
		opp_last_move = Move.cooperate;
	}
	public Tactic copy() {
		return new CopyCat();
	}
	public Move choose() { return opp_last_move;} ;
	public void reset() {opp_last_move = Move.cooperate; coins= 0;}
	public void end_of_turn(Move my_last_move, Move opp_last_move, int a) {
		this.opp_last_move = opp_last_move;
		coins+= a;
	}
	public void end_of_match() {opp_last_move = Move.cooperate;}
	
}
