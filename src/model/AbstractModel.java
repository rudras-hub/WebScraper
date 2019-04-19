package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class AbstractModel implements Model {
	
	private PropertyChangeSupport support; 
	
	public AbstractModel() {
		this.support = new PropertyChangeSupport(this);
	}
	
	public void addListener(PropertyChangeListener listener) {
		support.addPropertyChangeListener(listener);
	}
	
	public void removeListener(PropertyChangeListener listener) {
		support.removePropertyChangeListener(listener);
	}
	
	public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
		support.firePropertyChange(propertyName, oldValue, newValue);
	}
}	
	


