package controller;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.input.MouseEvent;
import model.GameSettings;

public class Tab2_controller {
	private GameSettings gs;
	public Tab2_controller() {
		gs = new GameSettings(2, 0, 3, -1);
	}
	public GameSettings ask_for_gs() {return gs;}
	@FXML
	public List<Spinner<Integer>> spinnerlist;
	@FXML
	public void spin(MouseEvent me) {
		Spinner<Integer> s = (Spinner<Integer>) me.getSource();
		final int i = (-2 * (spinnerlist.indexOf(s) % 2) + 1) + spinnerlist.indexOf(s);
		spinnerlist.get(i).getValueFactory().setValue(s.getValue());
		gs.set(spinnerlist.get(0).getValue(), spinnerlist.get(6).getValue(), spinnerlist.get(2).getValue(),
				spinnerlist.get(4).getValue());

	}
}
