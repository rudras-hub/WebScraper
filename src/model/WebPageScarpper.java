package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class WebPageScarpper {
	
	private URL url; 
	
	private String actionResponse; 
	
	private List<String> readLines;
	
	private InputStream inputStream;
	
	private BufferedReader reader; 
	
	public WebPageScarpper(URL inputUrl) {
		this.url = inputUrl;
		this.readLines = new ArrayList<String>();
	}
	
	public URL getUrl() {
		return this.url;
	}
	
	public String getActionResponse() {
		return this.actionResponse;
	}
	
	public void ReadPage() {
		try {
			inputStream = url.openStream(); 
			reader = new BufferedReader(new InputStreamReader(inputStream));
			String line;  
			
			while((line = reader.readLine()) != null) {
				readLines.add(line); 
			}
			
			actionResponse = "Success!";
		}
		catch (MalformedURLException e) {
			actionResponse = "Invalid URL";
		}
		catch(IOException e) {
			actionResponse = "An I/O error has occurred"; 
		}
		finally {
			try {
				if(reader != null) {
					reader.close();
				}
				
				if(inputStream != null) {
					inputStream.close();
				}
			}
			catch(IOException e) {
				actionResponse = "An error occurred when closing the stream";
			}

		}
	}

}
