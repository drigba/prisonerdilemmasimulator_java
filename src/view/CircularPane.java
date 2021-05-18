package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import model.Tactic;

public class CircularPane extends AnchorPane {

    private final double radius;

    private final double int_gap;


    public CircularPane(double radius, double int_gap, int no_images)
    {
    	this.radius=radius;
        this.int_gap=int_gap;
        for(int i = 0; i < no_images; i++)
        {
        	ImageView imgv = new ImageView();
        	getChildren().add(imgv);	
        }
    	
    }
    
    public CircularPane(double radius, double int_gap, int no_images, String src) throws FileNotFoundException{
        this.radius=radius;
        this.int_gap=int_gap;
        FileInputStream input = new FileInputStream(src);
		Image image = new Image(input);
        for(int i = 0; i < no_images; i++)
        {
        	ImageView imgv = new ImageView(image);
        	getChildren().add(imgv);
        	
        }
    }
    public void set_Images(ArrayList<Tactic> tax ) throws FileNotFoundException {
    	
    	
    	for(int i = 0; i<tax.size(); ++i)
    	{
    		FileInputStream inputStream = new FileInputStream(tax.get(i).get_ImgSrc());
    		Image imgImage = new Image(inputStream);
    		ImageView imgv = new ImageView(imgImage);
    		getChildren().set(i, imgv);
    		
    		
    	}

    	
    	
    }
    public void layoutChildren() {
        int n=getChildren().size();
        double incr = Math.toRadians(360.0/ getChildren().size());
        double imgSize = (2*radius - n/2*int_gap)/((n/2)); 
        double deg=0;
        for (Node node : getChildren()) {
        	((ImageView)node).setFitHeight(imgSize);
            ((ImageView)node).setFitWidth(imgSize);
            double x = radius * Math.cos(deg) + getWidth() / 2;
            double y = radius * Math.sin(deg) + getHeight() / 2;

            layoutInArea(node, x - node.getBoundsInLocal().getWidth() / 2, y - node.getBoundsInLocal().getHeight() / 2, getWidth(), getHeight(), 0.0, HPos.LEFT, VPos.TOP);
   
            
            deg += incr;

        }
       

        

    }
}
