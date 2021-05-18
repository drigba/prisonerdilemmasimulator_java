package model;

import java.util.Random;


public class Singleplayer {
	private static Tactic[] tactics;
	private boolean ended;
	private Tactic opponent;
	private GameSettings settings;
	private Tactic player;
	public static Tactic[] get_Tactics() {return tactics;}
	public Tactic getOpponent() {return opponent;}
	public Tactic getPlayer() {return player;}
	static {
		tactics = new Tactic[] {new CopyCat(), new Alwayscheat(), new Alwayscoop(), new Grudger(), new Simpleton(), new Copykitten(), new Whoknows()};
		
	}
	public Singleplayer ()
	{
		
		
		player = new Player();
		Random rngRandom = new Random();
		opponent = tactics[rngRandom.nextInt(7)].copy();
		System.out.println(opponent.getClass().getName());
		
	}
	public boolean get_ended() {return ended;}

	public void play() {


		if(!ended) {
			Match.play_round(player, opponent, settings);
			settings.decrease_rounds();
			ended = (settings.get_played_rounds()<=0);
			
			}
	
	}
	public void set_GameSettings(GameSettings g)
	{
		
		settings = new GameSettings(g);
	}
}
