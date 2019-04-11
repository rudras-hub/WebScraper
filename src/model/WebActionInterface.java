package model;

import java.net.URL;
import java.util.ArrayList;

public interface WebActionInterface {
	
	URL getUrl(); 
	
	String getResult(); 
	
	ArrayList<String> getResponse();
	
	void execute(); 
	
	void clearResponse(); 
	

}
