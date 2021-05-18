package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class Tournament implements Serializable {

	private static final long serialVersionUID = 11;
	private ArrayList<Tactic> StPlayers;
	private ArrayList<Tactic> CuPlayers;
	private GameSettings settings;
	private int[] output;
	public int[] get_output() {return output;}
	public ArrayList<Tactic> getStPlayers(){return StPlayers;}
	public ArrayList<Tactic> getCuPlayers(){return CuPlayers;}
	public Tournament(ArrayList<Tactic> t)
	{
		CuPlayers = t;
		StPlayers = t;
		
	}
	 void set_output() {
		int i = 0;
		output = new int[21];
		for(Tactic t: Singleplayer.get_Tactics())
		{
			for(Tactic ta: StPlayers)
			{
				if(t.get_Name() == ta.get_Name())
					output[i]++;
				
			}
			++i;
		}
		
		for(Tactic t: Singleplayer.get_Tactics())
		{
			for(Tactic ta: CuPlayers)
			{
				if(t.get_Name() == ta.get_Name())
					output[i]++;
				
			}
			++i;
		}
		for(int j = 0; j< 7; j++,i++)
		{
			output[i] = settings.get_possibles()[j];
			
		}
		
	}
	
	private void writeObject(ObjectOutputStream oos) throws IOException{
			if(output == null)
			{
				set_output();
				
			}
			
			
			
		oos.writeObject(output);
		
		
	}
	
	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException
	{
		output = (int[]) ois.readObject();
		
	}
	
	public Tournament () {
		StPlayers = new ArrayList<>();
		CuPlayers = new ArrayList<>();
		settings = new GameSettings();

		
	}
	
	public void reset_all() {
		for (Tactic t : CuPlayers) {
			t.reset();
		}

	}
	public void set_GameSettings(GameSettings gs)
	{
		settings = gs;
	}


	public void battle() {
		Match match = new Match();
			for (int i = 0; i < CuPlayers.size() - 1; ++i) {
				for (int j = i+1; j < CuPlayers.size(); ++j) {

					match.play(CuPlayers.get(i), CuPlayers.get(j), settings);
					
				}
			}
			annihilate();
			reset_all();
			
	
		
	}
	public void annihilate() {
		SortByCoins sorter = new SortByCoins();
		CuPlayers.sort(sorter);
		for (int i = 0; i < settings.get_no_eliminated_players(); ++i) {
			CuPlayers.get(i);
			CuPlayers.set(i, CuPlayers.get(CuPlayers.size() - i-1).copy());
		}
	}
}
