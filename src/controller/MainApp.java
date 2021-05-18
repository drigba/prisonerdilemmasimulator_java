package controller;
import java.net.URL;
import java.nio.file.Paths;



import view.CircularPane;
import view.MyStage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;

import javafx.scene.control.SplitPane;
import javafx.scene.control.TabPane;

import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.StackPane;

import javafx.stage.Stage;
import javafx.util.Pair;

public class MainApp extends Application {

	
	
	private void load_main_menu(MyStage s) throws Throwable
	{
		
		URL url = Paths.get("src\\view\\MainMenu.fxml").toUri().toURL();
		FXMLLoader loader = new FXMLLoader(url);
		AnchorPane mainMenuParent = loader.load();
		
		Scene mainScene = new Scene(mainMenuParent);
		s.add_poss_scene("mainmenu", mainScene);

		
	}
	
	private void load_results(MyStage s) throws Throwable
	{
		URL url = Paths.get("src\\view\\resultspane.fxml").toUri().toURL();
		FXMLLoader loader = new FXMLLoader(url);
		AnchorPane resultParent = loader.load();
		Scene resultScene = new Scene(resultParent);
		s.add_poss_scene("resultmenu", resultScene);
		

		
	}
	
	private Pair<RightpaneController, TabPane> load_tabs(MyStage s) throws Throwable
	{
		URL url = Paths.get("src\\view\\TabPane.fxml").toUri().toURL();
		 FXMLLoader loader = new FXMLLoader(url);
		TabPane tabs = loader.load();
		AnchorPane.setBottomAnchor(tabs, 0.0);
		AnchorPane.setTopAnchor(tabs, 0.0);
		AnchorPane.setLeftAnchor(tabs, 0.0);
		AnchorPane.setRightAnchor(tabs, 0.0);
		tabs.setMinWidth(325.0);
		tabs.setPrefWidth(325.0);
		tabs.setMaxWidth(325.0);
		tabs.getTabs().get(0);
		RightpaneController tc = loader.getController();

		return new Pair<RightpaneController, TabPane>(tc, tabs);
	
		
	}
	
	
	
	private void load_singe_left(MyStage s ) throws Throwable
	{
		URL url = Paths.get("src\\view\\single_left.fxml").toUri().toURL();
		FXMLLoader loader = new FXMLLoader(url);
		AnchorPane singleft = loader.load();
		SingleController sc = loader.getController();
		Pair<RightpaneController, TabPane> singeRight = load_tabs(s);
		sc.set_rpc(singeRight.getKey());
		SplitPane sp = new SplitPane(singleft, singeRight.getValue());
		Scene singleScene = new Scene(sp,1000,500);
		s.add_poss_scene("singlemenu", singleScene);
		singeRight.getValue().getTabs().remove(0);
		singeRight.getValue().getTabs().remove(1);




		
	}
	
	private void load_tournament_left(MyStage s, CircularPane leftCircle) throws Throwable
	{
		URL url = Paths.get("src\\view\\left_tour.fxml").toUri().toURL();
		FXMLLoader loader = new FXMLLoader(url);
		
		StackPane stack = loader.load();
		TournamentController tournamentController = loader.getController();
		Pair<RightpaneController, TabPane> tourRight = load_tabs(s);
		tournamentController.set_rpc(tourRight.getKey());
		stack.getChildren().add(leftCircle);
		tournamentController.set_circular_pane(leftCircle);
		SplitPane toursp = new SplitPane(stack, tourRight.getValue());
		Scene tournamentScene = new Scene(toursp, 1000,500);
		leftCircle.toBack();
		s.add_poss_scene("tournamentmenu", tournamentScene);
	}
	private void load_ovo(MyStage s) throws Throwable
	{
		URL url = Paths.get("src\\view\\one_on_one.fxml").toUri().toURL();
		FXMLLoader loader = new FXMLLoader(url);
		AnchorPane Ovo_left = loader.load();
		OvOController oc = loader.getController();
		Pair<RightpaneController, TabPane> ovoRight = load_tabs(s);
		oc.set_rpc(ovoRight.getKey());
		SplitPane sp2 = new SplitPane(Ovo_left, ovoRight.getValue());
		Scene ovo_scene = new Scene(sp2,1000,500);
		s.add_poss_scene("ovomenu", ovo_scene);
		ovoRight.getValue().getTabs().remove(0);
		ovoRight.getKey().get_tab3().disable_nodes(2);
		ovoRight.getKey().get_tab3().disable_nodes(1);

		
		
	}
	
	
	private void initialize(MyStage s) throws Throwable {

		load_main_menu(s);
		load_results(s);
		load_singe_left(s);
		load_tournament_left(s, new CircularPane(200.0,5.0,28));	
		load_ovo(s);
		s.setScene("mainmenu");
		s.setTitle("Prisoner Dilemma Simulator 9000");
	}
	


	@Override
	public void start(Stage primaryStage) {

		
		
		
		try {
			
			MyStage stage = new MyStage();
			initialize(stage);
			stage.show();

		} catch(Exception e) {
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		
	
	
	public static void main(String[] args) {
		launch(args);
		


	}
}
