package model;

public class Alwayscoop extends Tactic {
	public Alwayscoop(Alwayscoop a) {
		super(a);
	}
	private static String Name = "Alwayscoop";
	public String get_Name () {return Name;}
	private static String ImgSrc = "src\\view\\allcoop.png";
	public String get_ImgSrc() {return ImgSrc;}
	public Alwayscoop() {
		
	}
	public Tactic copy() {
		return new Alwayscoop();
	}
	// MISSING END OF TURN ACTION
	public Move choose() {
		return Move.cooperate;

	}

}
