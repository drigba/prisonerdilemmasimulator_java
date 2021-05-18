package model;



public class Alwayscheat extends Tactic {
	public Alwayscheat(Tactic a) {super(a);

	}
	private static String Name = "Alwayscheat";
	
	
	public String get_Name () {return Name;}
	private static String ImgSrc = "src\\view\\allcheat.jpg";
	public String get_ImgSrc() {return ImgSrc;}
	public Alwayscheat() {
		// TODO Auto-generated constructor stub
	}
	public Tactic copy() {
		return new Alwayscheat();
	}
	//MISSING END OF TURN ACTION
	public Move choose() {
		return Move.cheat;
	}
}


