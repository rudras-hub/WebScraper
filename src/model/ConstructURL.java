package model;

import java.net.MalformedURLException;
import java.net.URL;

public class ConstructURL {
		
	private static final String PREFIX = "www.";
	
	private static final String SUFFIX = ".com";
	
	private String siteAddress;
	
	private String urlString = null;
	
	private URL url;
	
	public ConstructURL(String baseAddress) {
		
		this.siteAddress = baseAddress;
		BuildString();
	}
	
	public String getUrlString() {
		return this.urlString;
	}
	
	public URL getUrl() throws MalformedURLException {
		this.url= new URL(this.urlString); 
		return this.url;
	}
	
	private void BuildString() { 
		if(siteAddress.isEmpty())
			throw new NullPointerException(); 
		
		if(!siteAddress.contains(PREFIX))
			this.urlString = PREFIX + siteAddress; 
		
		if(!siteAddress.contains(SUFFIX))
			this.urlString = siteAddress + SUFFIX;	
	}


}
