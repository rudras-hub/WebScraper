package model;

import java.net.URL;
import java.util.ArrayList;

/**
 * Web action interface.
 * @author Suchi
 */
interface WebAction {
	
	/**
	 * Gets the URL for the action.
	 * @return The URL.
	 */
	URL getUrl(); 
	
	/**
	 * Gets the result of an action.
	 * @return The result of the action.
	 */
	String getResult(); 
	
	/**
	 * Gets the response received for the action
	 * @return Response for the action
	 */
	ArrayList<String> getResponse();
	
	/**
	 * Executes a web action and
	 * sets the result and response for
	 * the action.
	 */
	void execute(); 
}
