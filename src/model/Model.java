package model;

import java.beans.PropertyChangeListener;

/**
 * Defines interface for a Model class.
 * @author suchi
 */
public interface Model {
	
	/**
	 * Adds a listener to be notified on property changes.
	 * @param listener is notified by a model.
	 */
	public void addListener(PropertyChangeListener listener); 
	
	/**
	 * Removes an existing listener.
	 * @param listener is no longer notified of property changes, once removed. 
	 */
	public void removeListener(PropertyChangeListener listener);
	
	/**
	 * Fires event to notify listeners of changes to properties of a Model.
	 * @param propertyName Name of the property updated.
	 * @param oldValue Value of property before the update.
	 * @param newValue Value of property after the update.
	 */
	public void firePropertyChange(String propertyName, Object oldValue, Object newValue); 

}
