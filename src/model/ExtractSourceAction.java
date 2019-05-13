package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Web action to extract source HTML of a page.
 * @author Suchi
 */
class ExtractSourceAction extends AbstractWebAction{
	
	private InputStream inputStream;
	
	private BufferedReader reader; 
	
	/**
	 * Initializes a new instance of this class
	 * @param inputUrl URL input
	 */
	public ExtractSourceAction(URL inputUrl) {
		super(inputUrl); 
	}

	@Override
	public void execute() {
		try {
			inputStream = url.openStream(); 
			reader = new BufferedReader(new InputStreamReader(inputStream));
			String line;  
			
			while((line = reader.readLine()) != null) {
				response.add(line); 
			}
			
			result = "Success!";
		}
		catch (MalformedURLException e) {
			result = "Invalid URL";
		}
		catch(IOException e) {
			result = "An I/O error has occurred"; 
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
				result = "An error occurred when closing the stream";
			}

		}
		
	}
}
