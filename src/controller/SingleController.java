package controller;

import java.io.IOException;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Move;
import model.Singleplayer;

public class SingleController extends ParentController{

	private Singleplayer singleplayer;
	private RightpaneController rpc;
	
	
	public void set_rpc(RightpaneController right) {
		rpc = right;
	}

	


	@FXML
	private AnchorPane endgamemessage;
	
	@FXML 
	 private Button coopButton;
	
	@FXML
	 private Button cheatButton;
	
	@FXML
	 private Button startButton;
	
	@FXML
	 private Label PlayerLabel;
	
	@FXML
	 private Label OpponentLabel;

	public  void UpdateLabels() {
		
		PlayerLabel.setText(String.valueOf(singleplayer.getPlayer().get_coins()));
		OpponentLabel.setText(String.valueOf(singleplayer.getOpponent().get_coins()));
		
		if(singleplayer.get_ended()) { 
			endgamemessage.setVisible(true);
			cheatButton.setDisable(true);
			coopButton.setDisable(true);
			startButton.setVisible(true);
		}
		
	}
	public void change_menu(MouseEvent me) {
		reset();
		startButton.setVisible(true);
		super.change_menu(me);
	}
	
	
	@FXML
	public void startGame()  {
		reset();
		startButton.setVisible(false);
		
		
		singleplayer = new Singleplayer();
		singleplayer.set_GameSettings(rpc.get_gs());
	}
	
	public void reset()
	{
		PlayerLabel.setText("0");
		OpponentLabel.setText("0");
		endgamemessage.setVisible(false);
		cheatButton.setDisable(false);
		coopButton.setDisable(false);
		
	}
	
	@FXML
	public void impressed(MouseEvent me) {
		Button button = (Button)me.getSource();
		Move m = Move.cooperate;
		if(button.getId().compareTo("cheatButton")== 0)
			m = Move.cheat;
		singleplayer.getPlayer().setNext(m);
		singleplayer.play();
		UpdateLabels();
		
	}
	
	

	
}
