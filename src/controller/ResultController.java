 	 package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import model.Tournament;

public class ResultController extends ParentController {

	private boolean first_time;

	public ResultController() {
		first_time = true;
	}

	@FXML
	private GridPane gridPane;

	@SuppressWarnings("unchecked")
	@FXML
	public void load() throws  IOException, ClassNotFoundException  {
		ArrayList<Tournament> inputArrayList = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream("test.ser");
			@SuppressWarnings("resource")
			ObjectInputStream objectInputStream = new ObjectInputStream(fis);
			inputArrayList = (ArrayList<Tournament>) objectInputStream.readObject();
		} finally {
			for (int i = 0; i < inputArrayList.size(); ++i) {
				for (int j = 0; j < inputArrayList.get(i).get_output().length; ++j) {
					if (first_time) {
						Label label = new Label(String.valueOf(inputArrayList.get(i).get_output()[j]));
						gridPane.add(label, j, i + 2);

					} else {
						Label label = (Label)getNodeFromGridPane(j, i );
						label.setText(String.valueOf(inputArrayList.get(i).get_output()[j]));
					}

				}

			}
			first_time = false;
		}

	}

	private Node getNodeFromGridPane(int col, int row) {
		
		  for (Node node : gridPane.getChildren()) { 
			  if ((GridPane.getRowIndex(node) ==  row + 2) && GridPane.getColumnIndex(node) == col )
			  { 
				  return node; 
				  } 
			  }
		 
		
		
		return null;
	}
}
