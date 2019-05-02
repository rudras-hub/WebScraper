package model;

import java.net.URL;
import java.util.ArrayList;

public interface WebAction {
	
	URL getUrl(); 
	
	String getResult(); 
	
	ArrayList<String> getResponse();
	
	void setResult(String resultText);
	
	void execute(); 
	
	void clearResponse(); 
	

}
