package view;

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Pair;

public class MyStage extends Stage {
	public ArrayList<Pair <String, Scene >> possible_scenes;
	public MyStage() {
		possible_scenes = new ArrayList<>();
	}
	public void add_poss_scene(String id, Scene s)
	{
		possible_scenes.add(new Pair<String, Scene>(id, s));
	}
	
	public void setScene(String id)
	{
		for(Pair<String, Scene> pair : possible_scenes)
		{
			if(pair.getKey().compareTo(id) == 0)
			{
				hide();
				setScene(pair.getValue());
				show();
				break;
			}
			
		}
		
	}

}
