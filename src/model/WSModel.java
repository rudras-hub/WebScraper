package model;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class WSModel extends AbstractModel {
	
	private AbstractWebAction action; 
	
	private String actionResult; 
	
	private ArrayList<String> actionResponse; 
	
	private String actionURL;
	
	public WSModel() {
		super(); 
	}
	
	public void executeAction() {
		String oldResult = this.actionResult; 
		ArrayList<String> oldResponse = this.actionResponse;
		
		action.execute();
		
		this.actionResult = action.getResult();
		this.actionResponse = action.getResponse();
		
		firePropertyChange("actionResult", oldResult, actionResult);
		firePropertyChange("actionResponse", oldResponse, actionResponse);
	}
	
	public void clearPage() {
		String oldResult = this.actionResult; 
		ArrayList<String> oldResponse = this.actionResponse;
		
		this.actionResult = "";
		this.actionResponse = new ArrayList<String>();
		
		firePropertyChange("actionResult", oldResult, actionResult);
		firePropertyChange("actionResponse", oldResponse, actionResponse);
	}
	
	public String getActionResult() {
		return action.getResult();
	}
	
	public ArrayList<String> getActionResponse(){
		return action.getResponse();
	}
	
	public void setActionResult(String text) {
		String oldValue = this.actionResult;
		this.actionResult = text;
		firePropertyChange("actionResult", oldValue, actionResult);
	}
	
	public void setActionResponse(ArrayList<String> responseText) 
	{
		ArrayList<String> oldValue = this.actionResponse;
		this.actionResponse = responseText;
		firePropertyChange("actionResponse", oldValue, actionResponse);
	}
	
	public void setActionURL(String inputUrl) {
		String oldValue = this.actionURL;
		this.actionURL = inputUrl;
		ConstructURL urlBuilder;
		URL url;
		try {
			urlBuilder = new ConstructURL(this.actionURL); 
			url = urlBuilder.getUrl(); 
			this.action = new ReadPage(url); 
		}
		catch(MalformedURLException e) {
			setActionResult("Invalid URL");
		}
		finally 
		{
			firePropertyChange("actionURL", oldValue, actionURL);
		}
	}
	

}
