package model;

import java.net.URL;
import java.util.ArrayList;

/**
 * Abstract web action class.
 * @author suchi
 */
public abstract class AbstractWebAction implements WebAction {
	
	protected static final String EMPTY_STRING = ""; 
	
	protected URL url; 
	
	protected String result; 
	
	protected ArrayList<String> response;
	
	/**
	 * Initializes this abstract class
	 * @param inputUrl URL to initialize an action with.
	 */
	public AbstractWebAction(URL inputUrl) {
		this.url = inputUrl;
		this.response = new ArrayList<String>();
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	public URL getUrl() {
		return this.url;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String getResult() {
		return this.result;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public ArrayList<String> getResponse(){
		return this.response;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public abstract void execute();
}
