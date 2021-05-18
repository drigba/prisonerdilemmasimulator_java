package controller;

import javafx.fxml.FXML;
import model.GameSettings;

public class RightpaneController extends ParentController {
	@FXML
	private Tab1_controller tab1Controller;
	
	@FXML
	private Tab2_controller tab2Controller;
	
	@FXML
	private Tab3_controller tab3Controller;
	
	public GameSettings get_gs() {
		GameSettings gSettings = tab2Controller.ask_for_gs();
		gSettings.set_notoutcomes(tab3Controller.get_settings());
		return gSettings;
		
		
	}

	public Tab1_controller get_tab1() {return tab1Controller;}
	public Tab2_controller get_tab2() {return tab2Controller;}

	public Tab3_controller get_tab3() {return tab3Controller;}

	

}
