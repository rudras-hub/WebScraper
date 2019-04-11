package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class ReadPage extends WebAction{
	
	private InputStream inputStream;
	
	private BufferedReader reader; 
	
	public ReadPage(URL inputUrl) {
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

	@Override
	//TODO: add custom clear
	public void clearResponse() {
		response.clear();
		
	}

}
