package model;

import java.io.IOException;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpCommunication extends WebAction {
	
	private int httpStatus = 0;
	
	private String urlString;
	
	private CloseableHttpClient client; 
	
	public HttpCommunication(URL inputUrl) {
		super(inputUrl);
		this.urlString = inputUrl.toString();
		this.client = HttpClients.createDefault();
	}
	
	public int getHttpStatus() {
		return this.httpStatus;
	}	

	@Override
	public void execute() {
		try {
			HttpGet httpGet = new HttpGet(this.urlString); 
			HttpResponse rawResponse = client.execute(httpGet);
			
			ResponseHandler<String> handler = new BasicResponseHandler();
			response.add(handler.handleResponse(rawResponse));
			httpStatus = rawResponse.getStatusLine().getStatusCode();
			response.add("HTTP Status Code: " + httpStatus); 
			result = "Success!";
		}
		catch(HttpResponseException e) {
			result = "Check if website exists";

		}
		catch(ClientProtocolException e) {
			result = "Http protocol error encountered";
		}
		catch(IOException e) {
			result = "Check internet connection";
		}
		
	}

	@Override
	//TODO: add custom clear
	public void clearResponse() {
		response.clear();
		result = EMPTY_STRING; 
		
	}
}
