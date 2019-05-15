package controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import model.Model;
import view.View;

/**
 * Abstract controller class.
 * @author Suchi
 */
public abstract class AbstractController implements PropertyChangeListener {
	
	private ArrayList<Model> registeredModels;
	private ArrayList<View> registeredViews; 
	
	/**
	 * Initializes this abstract class.
	 */
	public AbstractController() {
		this.registeredModels = new ArrayList<Model>(); 
		this.registeredViews = new ArrayList<View>(); 
	}
	
	/**
	 * Adds a model to register itself as a listener
	 * to get notifications of the model class. 
	 * @param model
	 */
	public void addModel(Model model) {
		registeredModels.add(model); 
		model.addListener(this);
	}
	
	/**
	 * Removes itself as a listener of the model class. 
	 * No longer receives notifications from the model class.
	 * @param model
	 */
	public void removeModel(Model model) {
		registeredModels.remove(model); 
		model.removeListener(this);
	}
	
	/**
	 * Adds view to the cache.
	 * @param view The view to add
	 * @see View
	 */
	public void addView(View view) {
		registeredViews.add(view);
	}
	
	/**
	 * Removes view from the cache
	 * @param view The view to remove
	 * @see View
	 */
	public void removeView(View view) {
		registeredViews.remove(view); 
	}
	
	/**
	 * On receiving the ProprtyChange notification from the model class,
	 * passes it along to the view to be handled.
	 */
	public void propertyChange(PropertyChangeEvent evt) {
		for(View view: registeredViews) {
			view.OnPropertyChange(evt);
		}
	}
	
	/**
	 * Invokes a method on a registered model using reflection.
	 * @param methodName Name of the method to invoke.
	 * @param methodParameters Parameters of the method being invoked.
	 */
	protected void invokeModelMethod(String methodName, Object[] methodParameters) {
		for(Model model : registeredModels) 
		{
			try 
			{
				Method method;
				if(methodParameters == null) 
				{
					method = model.getClass()
							.getMethod(methodName);
					
					method.invoke(model);	
				}
				
				if(methodParameters.length == 1) 
				{
					method = model.getClass()
						.getMethod(methodName, new Class[] {methodParameters[0].getClass()});
				
					method.invoke(model, methodParameters[0]);
				}
				
				if(methodParameters.length == 2) 
				{
					method = model.getClass()
						.getMethod(methodName, new Class[] {methodParameters[0].getClass(), methodParameters[1].getClass()});
				
					method.invoke(model, methodParameters[0], methodParameters[1]);
				}
				
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
