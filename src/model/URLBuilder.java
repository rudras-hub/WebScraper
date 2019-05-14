package model;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Builds URL from string input.
 * @author Suchi
 */
class URLBuilder {
	
	private String siteAddress;
	
	private String urlString = null;
	
	private URL url;
	
	/**
	 * Initializes a new instance of URLBuilder class.
	 * @param baseAddress
	 */
	public URLBuilder(String baseAddress) {
		
		this.siteAddress = baseAddress;
		buildURLString();
	}
	
	/**
	 * Gets the string input.
	 * @return Returns the input string provided to the builder.
	 */
	public String getUrlString() {
		return this.urlString;
	}
	
	/**
	 * Gets the URL built
	 * @return Returns the URL constructed from the string input.
	 * @throws MalformedURLException
	 */
	public URL getUrl() throws MalformedURLException
	{
		this.url= new URL(this.urlString); 
		return this.url;
	}
	
	private void buildURLString() {
		final String PREFIX = "www.";
		
		final String SUFFIX = ".com";
		
		final String PROTOCOL = "https://";
		
		final String PROTOCOL_IDENTIFIER ="://";
		
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
		
		if(!siteAddress.contains(PROTOCOL_IDENTIFIER)) 
		{
			this.urlString = PROTOCOL + this.urlString;
		}
	}


}
