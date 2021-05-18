package model;

import java.io.Serializable;


public class GameSettings implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 00;
	private int no_eliminated_players;
	private int played_rounds;
	private int mistake;
	private int[][][] outcomes;

	public GameSettings() {

	}

	public GameSettings(GameSettings g) {
		this.outcomes = g.get_outcomes();
		this.mistake = g.get_mistake();
		this.played_rounds = g.get_played_rounds();
		this.no_eliminated_players = g.get_no_eliminated_players();

	}

	public GameSettings(int all_coop, int all_cheat, int one_cheat, int one_coop) {

		outcomes = new int[][][] { { { all_coop, all_coop }, { one_coop, one_cheat } },
				{ { one_cheat, one_coop }, { all_cheat, all_cheat } } };

	}

	public GameSettings(int all_coop, int all_cheat, int one_cheat, int one_coop, int mistake, int played_rounds) {

		outcomes = new int[][][] { { { all_coop, all_coop }, { one_coop, one_cheat } },
				{ { one_cheat, one_coop }, { all_cheat, all_cheat } } };
		this.mistake = mistake;
		this.played_rounds = played_rounds;
	}

	public GameSettings(int all_coop, int all_cheat, int one_cheat, int one_coop, int mistake, int played_rounds,
			int no_eliminated_players) {

		outcomes = new int[][][] { { { all_coop, all_coop }, { one_coop, one_cheat } },
				{ { one_cheat, one_coop }, { all_cheat, all_cheat } } };
		this.mistake = mistake;
		this.played_rounds = played_rounds;
		this.no_eliminated_players = no_eliminated_players;
	}

	public void set(int all_coop, int all_cheat, int one_cheat, int one_coop, int mistake) {
		set(all_coop, all_cheat, one_cheat, one_coop);
		this.mistake = mistake;

	}

	public void set(int all_coop, int all_cheat, int one_cheat, int one_coop) {
		outcomes = new int[][][] { { { all_coop, all_coop }, { one_coop, one_cheat } },
				{ { one_cheat, one_coop }, { all_cheat, all_cheat } } };
		played_rounds = 5;

	}

	public void set(int all_coop, int all_cheat, int one_cheat, int one_coop, int mistake, int no_eliminated_players) {
		set(all_coop, all_cheat, one_cheat, one_coop, mistake);
		this.no_eliminated_players = no_eliminated_players;

	}

	public void set(int all_coop, int all_cheat, int one_cheat, int one_coop, int mistake, int no_eliminated_players,
			int played) {
		set(all_coop, all_cheat, one_cheat, one_coop, mistake, no_eliminated_players);
		this.played_rounds = played;
	}

	public void set_notoutcomes(int[] triplet) {
		played_rounds = triplet[0];
		mistake = triplet[2];
		no_eliminated_players= triplet[1];
		
		
	}
	
	public int get_allcoop() {
		return outcomes[0][0][0];
	}

	public int get_allcheat() {
		return outcomes[1][1][1];
	}

	public int get_onecoop() {
		return outcomes[1][0][1];
	}

	public int get_onecheat() {
		return outcomes[1][0][0];
	}
	
	public int[] get_possibles() {
		return new int[] {outcomes[0][0][0],outcomes[1][1][1], outcomes[1][0][1],outcomes[1][0][0], played_rounds, no_eliminated_players, mistake};
		
	}

	public void decrease_rounds() {
		played_rounds--;

	}

	public int get_mistake() {
		return mistake;
	}

	public int[] prize(Move m1, Move m2) {
		return outcomes[m1.ordinal()][m2.ordinal()];
	}

	public int get_played_rounds() {
		return played_rounds;
	}

	public int get_no_eliminated_players() {
		return no_eliminated_players;
	}

	public int[][][] get_outcomes() {
		return outcomes;
	}
}
