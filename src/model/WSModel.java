package model;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class WSModel extends AbstractModel {
	
	private WebAction action; 
	
	private String result; 
	
	private ArrayList<String> response; 
	
	public WSModel(String inputUrl) {
		super(); 
		setAction(inputUrl); 
	}
	
	public void setResult() {
		String oldValue = this.result; 
		this.result = action.getResult();
		firePropertyChange("result", oldValue, result);
	}
	
	public void setResponse() {
		ArrayList<String> oldValue = this.response; 
		this.response = action.getResponse(); 
		firePropertyChange("response", oldValue, response);
	}
	
	
	private void setAction(String inputUrl) {
		ConstructURL urlBuilder; 
		URL url;
		try {
			urlBuilder = new ConstructURL(inputUrl); 
			url = urlBuilder.getUrl(); 
			this.action = new ReadPage(url); 
		}
		catch(MalformedURLException e) {
			this.action = null; 
		}
	}
	

}
