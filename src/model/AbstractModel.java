package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Abstract model class.
 * @author Suchi
 */
abstract class AbstractModel implements Model {
	
	private PropertyChangeSupport support; 
	
	/**
	 * Initializes this abstract class.
	 */
	public AbstractModel() {
		this.support = new PropertyChangeSupport(this);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void addListener(PropertyChangeListener listener) {
		support.addPropertyChangeListener(listener);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void removeListener(PropertyChangeListener listener) {
		support.removePropertyChangeListener(listener);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
		support.firePropertyChange(propertyName, oldValue, newValue);
	}
}	
	


