package main;

import model.*;
import view.*;
import controller.*;
/**
 * This class acts as glue code.
 * It instantiates the Model, View and
 * Controller and stitches them together.
 * @author suchi
 */
public class Program {
	
	/**
	 * The main method (entry to the application).
	 * @param args Unused
	 */
	public static void main(String[] args) {
		WSModel model = new WSModel();
		WSController controller = new WSController();
		WSView view = new WSView(controller);
		
		controller.addModel(model);
		controller.addView(view);
	}

}
