package controller;



import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import model.CopyCat;
import model.GameSettings;
import model.Match;
import model.Singleplayer;
import model.Tactic;

public class OvOController extends ParentController{
	private RightpaneController rpc;
	private Tactic[] tactics;
	public void set_rpc(RightpaneController right)
	{
		rpc = right;
	}
	@FXML
	ImageView leftImgV;
	
	@FXML
	ImageView rightImgV;
	
	/*@FXML
	GridPane leftgrid;*/
	
	@FXML
	Label LeftLabel;
	
	@FXML
	Label RightLabel;
	
	@FXML
	AnchorPane beforegamemessage;
	
	@FXML
	Button startbutton;
	@FXML
	Text text;
	@FXML
	Button mainmenu;
	
	/*@FXML
	GridPane rightgrid;*/
	public OvOController () {
		tactics = new Tactic[] {new CopyCat(),new CopyCat()};
		
		
	}
	

	public void change_menu(MouseEvent me) {
		super.change_menu(me);
		UpdateLabels();
		
	}
	@FXML
	public void getTactic(MouseEvent me) {
		Button button = (Button)me.getSource();
		int column = GridPane.getColumnIndex(button);
		int row = GridPane.getRowIndex(button);
		tactics[column] = Singleplayer.get_Tactics()[row].copy();
		
		
	}
	
	
	@FXML 
	public void startgame() throws FileNotFoundException 
	{
		UpdateLabels();
		beforegamemessage.setVisible(false);
		startbutton.setDisable(true);
		mainmenu.setDisable(true);

		GameSettings gs = rpc.get_gs();
		 FileInputStream input = new FileInputStream(tactics[0].get_ImgSrc());
			Image image = new Image(input);
		leftImgV.setImage(image);
		input = new FileInputStream(tactics[1].get_ImgSrc());
		Image image2 = new Image(input);
		rightImgV.setImage(image2);
		
		
		Thread thread = new Thread(() ->{
			for(int i = 0; i< gs.get_played_rounds(); ++i)
			{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Match.play_round(tactics[0], tactics[1], gs);
				
				Platform.runLater(()->UpdateLabels());
				
		
				
				
				
			}
			mainmenu.setDisable(false);
			beforegamemessage.setVisible(true);
			text.setText("Game ended\nChoose new players");
			startbutton.setDisable(false);

			
			
		});
		thread.start();
		tactics[0].reset();
		tactics[1].reset();
		
	}

	private void UpdateLabels() {
		LeftLabel.setText(String.valueOf(tactics[0].get_coins()));
		RightLabel.setText(String.valueOf(tactics[1].get_coins()));

		
	}
	
}