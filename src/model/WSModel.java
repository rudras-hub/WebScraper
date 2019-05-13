package model;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Model for web scraper application
 * @author Suchi
 */
public class WSModel extends AbstractModel {
	
	private AbstractWebAction action; 
	
	private String actionResult; 
	
	private ArrayList<String> actionResponse; 
	
	private String actionURL;
	
	/**
	 * Initializes a new web scraper model.
	 */
	public WSModel() {
		super(); 
	}
	
	/**
	 * Executes a web action and updates properties.
	 */
	public void executeAction() {
		String oldResult = this.actionResult; 
		ArrayList<String> oldResponse = this.actionResponse;
		
		action.execute();
		
		this.actionResult = action.getResult();
		this.actionResponse = action.getResponse();
		
		firePropertyChange("actionResult", oldResult, actionResult);
		firePropertyChange("actionResponse", oldResponse, actionResponse);
	}	
	
	/**
	 * Gets the result of the web action.
	 * @return Result the web action.
	 */
	public String getActionResult() {
		return action.getResult();
	}
	
	/**
	 * Gets the response of the web action.
	 * @return Response of web action
	 */
	public ArrayList<String> getActionResponse(){
		return action.getResponse();
	}
	
	/**
	 * Sets the URL to perform a web action on.
	 * @param inputUrl The input URL.
	 */
	public void setActionURL(String inputUrl) {
		String oldValue = this.actionURL;
		this.actionURL = inputUrl;
		URLBuilder urlBuilder;
		URL url;
		try {
			urlBuilder = new URLBuilder(this.actionURL); 
			url = urlBuilder.getUrl(); 
			this.action = new ExtractSourceAction(url); 
		}
		catch(MalformedURLException e) {
			setActionResult("Invalid URL");
		}
		finally 
		{
			firePropertyChange("actionURL", oldValue, actionURL);
		}
	}
	
	/**
	 * Sets the result of a web action.
	 * @param text Text to set as the result. 
	 */
	private void setActionResult(String text) {
		String oldValue = this.actionResult;
		this.actionResult = text;
		firePropertyChange("actionResult", oldValue, actionResult);
	}
	

}
