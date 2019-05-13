package view;

import java.beans.PropertyChangeEvent;

/**
 * Defines interface for a view class
 * @author Suchi
 *
 */
public interface View {
	
	/**
	 * Event handler for PropertChange event. 
	 * Defines the next steps when the event is raised.
	 * @param event PropertyChangeEvent caught by the handler
	 * @see PropertyChangeEvent
	 */
	public void OnPropertyChange(PropertyChangeEvent event); 

}
