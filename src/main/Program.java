package main;

import model.*;
import view.*;
import controller.*;

public class Program {
	
	public static void main(String[] args) {
		WSModel model = new WSModel();
		WSController controller = new WSController();
		WSView view = new WSView(controller);
		
		controller.addModel(model);
		controller.addView(view);
	}

}
