package model;

import java.beans.PropertyChangeListener;

public interface Model {
	
	public void addListener(PropertyChangeListener listener); 
	
	public void removeListener(PropertyChangeListener listener);
	
	public void firePropertyChange(String propertyName, Object oldValue, Object newValue); 

}
