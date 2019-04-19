package model;

import java.net.URL;
import java.util.ArrayList;

public abstract class WebAction implements WebActionInterface {
	
	protected static final String EMPTY_STRING = ""; 
	
	protected URL url; 
	
	protected String result; 
	
	protected ArrayList<String> response;
	
	public WebAction(URL inputUrl) {
		this.url = inputUrl;
		this.response = new ArrayList<String>();
		
	}
	
	public URL getUrl() {
		return this.url;
	}
	
	public String getResult() {
		return this.result;
	}
	
	public ArrayList<String> getResponse(){
		return this.response;
	}
	
	public abstract void execute(); 
	
	public abstract void clearResponse();

}
