package controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
	
	protected void invokeModelMethod(String methodName, Object newValue) {
		for(Model model : registeredModels) 
		{
			try 
			{
				Method method;
				if(newValue == null) {
					method = model.getClass().getMethod(methodName);
					
				}
				else 
				{
				method = model.getClass()
						.getMethod(methodName, new Class[] {newValue.getClass()});
				}
				
				method.invoke(model, newValue);
				
			} 
			catch (NoSuchMethodException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
