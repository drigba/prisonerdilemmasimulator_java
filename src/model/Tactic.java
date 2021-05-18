package model;




public abstract class Tactic  {
	private static String Name = "Tactic";
	
	public String get_Name () {return Name;}
	protected static String ImgSrc;
	protected Move nextMove;
	protected int coins;
	
	public Tactic(Move m){}
	
	public Tactic() {}
	
	public Tactic(Tactic a) {}
	
	public void setNext(Move m){nextMove = m;}
	
	public String get_ImgSrc() {return ImgSrc;}
	public int get_coins() {return coins;}
	
	public void inc_coins(int a){coins+= a;}
	
	abstract Move choose();
	
	
	public void reset() {coins = 0;}
	
	public abstract Tactic copy();
	
	public void end_of_turn(Move my_last_move, Move opp_last_move, int a) {inc_coins(a);}
	
	public void end_of_match() {}
	
	public boolean equals(Object o) {
		Tactic t = (Tactic) o;
		if(get_Name() == t.get_Name())
			return true;
		return false;

	}
}
