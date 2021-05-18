package controller;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import view.MyStage;

abstract class ParentController {
	public void change_menu(MouseEvent me) {
		Button b = (Button) me.getSource();
		MyStage stageTheEventBelongStage = (MyStage) ((Node)me.getSource()).getScene().getWindow();
		
		stageTheEventBelongStage.setScene(b.getId()); //tesztelni
	}
}
