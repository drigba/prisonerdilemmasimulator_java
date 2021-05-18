package controller;



import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import model.Singleplayer;
import model.Tactic;

public class Tab1_controller {
	@FXML
	private GridPane gridPane;
	@FXML
	private List<Slider> slidelist;
	@FXML
	List<Label> lablist;
	public Tab1_controller() {
	}
	public void ask_for_tactics(ArrayList<Tactic> resultArrayList) {
		for (int i = 0; i < 7; ++i) {
			for (int j = 0; j < Math.round(slidelist.get(i).getValue()); ++j) {
				resultArrayList.add(Singleplayer.get_Tactics()[i].copy());
			}

		}

	}
	
	private void equal_remaining(int remaining, int row) {
		int parts_left = slidelist.size() - 1;

		for (int i = 0; parts_left > 0 && i < 7; i++) {
			int size = (remaining + parts_left - 1) / parts_left; // rounded up, aka ceiling
			if (i == row - 1)
				++i;

			slidelist.get(i).setValue(size);
			lablist.get(i).setText(String.valueOf(size));
			remaining -= size;
			parts_left--;

		}
		
	}
	
	@FXML
	public void writeO(javafx.scene.input.MouseEvent me) {

		Slider slider = (Slider) me.getSource();
		int row = GridPane.getRowIndex(slider.getParent());
		int val = (int) Math.round( slider.getValue());
		equal_remaining(28-val, row);
		lablist.get(row - 1).setText(String.valueOf(val));

	}

}
