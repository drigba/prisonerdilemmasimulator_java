package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import model.Tournament;
import view.CircularPane;

public class TournamentController extends ParentController{
  private Boolean on_going;
	@FXML
	private Button startbutton;
	@FXML
	private Button savebutton;
	private RightpaneController rpc;
	private Tournament tournament;
	private CircularPane mcp;

	public void change_menu(MouseEvent me)  {
		super.change_menu(me);
		if(on_going)
			switch_button();
		
		
		
	}
	public TournamentController() {

		on_going= false;
	}
	public void set_circular_pane(CircularPane cp)  {
		mcp = cp;
		
	}
	
	
	
	public void set_rpc(RightpaneController right) {
		rpc = right;
		
	}
	
	public void update(Tournament t) throws FileNotFoundException {

		mcp.set_Images(t.getCuPlayers());
		
	}
	public void switch_button() {
		if(on_going) {
			on_going = false;
			startbutton.setText("Start");
			savebutton.setVisible(true);
		}
		else {
			on_going=true;
			startbutton.setText("Stop");
			savebutton.setVisible(false);
		}
		
	}
	
	 
	@FXML
	public void start_game() throws InterruptedException, IOException, ClassNotFoundException {
		
			if(!on_going)
			{
				on_going = true;
			 tournament = new Tournament();
			tournament.set_GameSettings(rpc.get_gs());
			rpc.get_tab1().ask_for_tactics(tournament.getCuPlayers());
			rpc.get_tab1().ask_for_tactics(tournament.getStPlayers());
			
			Thread thread = new Thread(()-> {
				while(on_going)
				{

					javafx.application.Platform.runLater(() ->{
						try {
							
							mcp.set_Images(tournament.getCuPlayers());
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
					
					});
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						tournament.battle();
					
					
				}
				
			});
			
		
			thread.start();
			switch_button();
			
	}
			switch_button();
		
	
	
			
	
			
	}
	@FXML	
	private void save() throws IOException, ClassNotFoundException {
		ArrayList<Tournament> results = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream("test.ser");

			ObjectInputStream ois = new ObjectInputStream(fis);
			results = (ArrayList<Tournament>)ois.readObject();
			ois.close();
			
		} finally {
			if(results.size()  < 10)
			{
				results.add(tournament);

				
			}
			else {
				results.set(0, tournament);
				Collections.rotate(results, -1);
			}
		}
		
		
		FileOutputStream fos = new FileOutputStream("test.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(results);
		oos.close();
		
		
	}

		
		

	
	public  Boolean is_it_still_going() {
		return on_going;
	}

	
	
	
	
}
