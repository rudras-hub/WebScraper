package model;

import java.net.MalformedURLException;
import java.net.URL;

public class ConstructURL {
		
	private static final String PREFIX = "www.";
	
	private static final String SUFFIX = ".com";
	
	private static final String PROTOCOL = "https://";
	
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
	
	public URL getUrl() throws MalformedURLException
	{
		this.url= new URL(this.urlString); 
		return this.url;
	}
	
	private void BuildString() {
		this.urlString = siteAddress;
		
		if(siteAddress.isEmpty())
		{
			throw new NullPointerException(); 
		}
		
		if(!siteAddress.contains(PREFIX))
		{
			this.urlString = PREFIX + this.urlString; 
		}
		
		if(!siteAddress.contains(SUFFIX))
		{
			this.urlString += SUFFIX;
		}
		
		this.urlString = PROTOCOL + this.urlString;
	}


}
