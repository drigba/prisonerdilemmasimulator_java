package model;

import java.util.Comparator;

public class SortByCoins implements Comparator<Tactic> {
	public int compare(Tactic a, Tactic b) {
		return a.coins-b.coins;
	}
}
