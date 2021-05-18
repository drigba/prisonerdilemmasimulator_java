package model;

import java.util.Random;

public class Match {
	public static void play(Tactic a, Tactic b, GameSettings g)
	{
		
		for(int i = 0; i< g.get_played_rounds(); ++i)
		{		
			play_round(a, b, g);

		}
		a.end_of_match();
		b.end_of_match();
	}
	static public void play_round(Tactic a, Tactic b, GameSettings g)
	{
		Random rngRandom = new Random(System.currentTimeMillis());
		Move a_Move = a.choose();
		Move b_Move = b.choose();
		int chance = rngRandom.nextInt(100);
		if(chance < g.get_mistake())
			a_Move= a_Move.negate();
		chance = rngRandom.nextInt(100);
		if(chance < g.get_mistake())
			b_Move= b_Move.negate();
		int[] tmp = g.prize(a_Move, b_Move);
		a.end_of_turn(a_Move, b_Move, tmp[0]);
		b.end_of_turn(b_Move, a_Move, tmp[1]);
		
	}
	
}
