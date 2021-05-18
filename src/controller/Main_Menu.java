package controller;



import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import view.MyStage;

public class Main_Menu extends ParentController{
		

		
		
		@FXML 
		public void exit(MouseEvent me)  {
			Stage stageTheEventBelongStage = (Stage) ((Node)me.getSource()).getScene().getWindow();
			stageTheEventBelongStage.close();
		}
		
	}

