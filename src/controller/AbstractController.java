package controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import model.Model;
import view.View;

public abstract class AbstractController implements PropertyChangeListener {
	
	private ArrayList<Model> registeredModels;
	private ArrayList<View> registeredViews; 
	
	public AbstractController() {
		this.registeredModels = new ArrayList<Model>(); 
		this.registeredViews = new ArrayList<View>(); 
	}
	
	public void addModel(Model model) {
		registeredModels.add(model); 
		model.addListener(this);
	}
	
	public void removeModel(Model model) {
		registeredModels.remove(model); 
		model.removeListener(this);
	}
	
	public void addView(View view) {
		registeredViews.add(view);
	}
	
	public void removeView(View view) {
		registeredViews.remove(view); 
	}
	
	public void propertyChange(PropertyChangeEvent evt) {
		for(View view: registeredViews) {
			view.OnPropertyChange(evt);
		}
	}

}
