package controller;

import java.util.Random;

public class Controller {
	private String[] color;
	
	public void compChosesColor() {
		color = new String[4]; 
		Random rnd = new Random();
		
		for(int x = 0; x < 4; x++) {		
			if (rnd.nextInt(4) == 0) {
				color[x] = "-fx-background-color: green;";
			}else if (rnd.nextInt(4) == 1) {
				color[x] = "-fx-background-color: white;";
			}else if (rnd.nextInt(4) == 2) {
				color[x] = "-fx-background-color: blue;";
			}else color[x] = "-fx-background-color: red;";
		}	
	}
	
	
	public String[] getColor() {
		return color;
	}
	
	
	   private static Controller instance = null;
	   protected Controller() {
	      // Exists only to defeat instantiation.
	   }
	   public static Controller getInstance() {
	      if(instance == null) {
	         instance = new Controller();
	      }
	      return instance;
	   }
}
