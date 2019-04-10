package model;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpCommunicator {
	
	private static final String EMPTY_STRING = " " ;
	
	private String httpResponse; 
	
	private String actionResponse;
	
	private int httpStatus;
	
	private String urlString;
	
	private CloseableHttpClient client; 
	
	public HttpCommunicator(String url) {
		this.urlString = url;
		this.client = HttpClients.createDefault();
	}
	
	public String getHttpResponse() {
		return this.httpResponse;
	}
	
	public int getHttpStatus() {
		return this.httpStatus;
	}
	
	public String getActionResponse() {
		return this.actionResponse;
	}
	
	public void executeClient(){
		try {
			HttpGet httpGet = new HttpGet(this.urlString); 
			HttpResponse rawResponse = client.execute(httpGet);
			
			ResponseHandler<String> handler = new BasicResponseHandler();
			this.httpResponse = handler.handleResponse(rawResponse);
			this.httpStatus = rawResponse.getStatusLine().getStatusCode();
			this.actionResponse = "Success!";
		}
		catch(HttpResponseException e) {
			this.httpStatus = 0;
			this.httpResponse = EMPTY_STRING;
			this.actionResponse = "Check if website exists";

		}
		catch(ClientProtocolException e) {
			this.httpStatus = 0;
			this.httpResponse = EMPTY_STRING; 
			this.actionResponse = "Http protocol error encountered";
		}
		catch(IOException e) {
			this.httpStatus = 0;
			this.httpResponse = EMPTY_STRING;
			this.actionResponse = "Check internet connection";
		}
	}
}
