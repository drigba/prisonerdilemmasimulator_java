package model;

import java.util.Random;

public class Whoknows extends Tactic {
	private Random random;
	private static String Name = "Whoknows";
	private static String ImgSrc = "src\\view\\whoknows.jpg";
	public String get_Name () {return Name;}

	public String get_ImgSrc() {return ImgSrc;}
	public Whoknows(Tactic a) {
		super(a);
		random = new Random();
	}
	public Whoknows() {
		random = new Random();
	}
	public Tactic copy() {
		return new Whoknows();
	}
	
	public Move choose() {
		if(random.nextInt(2)== 0)
			return Move.cooperate;
		return Move.cheat;
	}

}
