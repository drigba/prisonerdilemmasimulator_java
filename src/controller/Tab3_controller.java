package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class Tab3_controller {
	private int[] settings;

	public Tab3_controller() {

		settings = new int[] { 5, 6, 0 };

	}
	
	@FXML
	private List<Label> tab3_lablist;
	
	@FXML
	private List<VBox> tab3_VBOX;
	
	public int[] get_settings() {return settings;}

	@FXML
	public void write1(MouseEvent me) {
		Slider slider = (Slider) me.getSource();

		int row = GridPane.getRowIndex(slider.getParent());
		settings[row] = (int) Math.round(slider.getValue());

		tab3_lablist.get(row).setText(String.valueOf(Math.round(slider.getValue())));

	}
	public void disable_nodes(int id) {
		tab3_lablist.get(id).setVisible(false);
		tab3_VBOX.get(id).setVisible(false);
		
	}
}
