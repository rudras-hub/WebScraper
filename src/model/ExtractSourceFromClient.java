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

/**
 * Web action to ping a web-site
 * @author Suchi
 *
 */
class ExtractSourceFromClient extends AbstractWebAction {
	
	private static final String STATUS_CODE_STRING = "Status Code: ";
	private int httpStatus = 0;
	
	private String urlString;
	
	private CloseableHttpClient client; 
	
	/**
	 * Initializes a new instance of this class.
	 * @param inputUrl URL input
	 */
	public ExtractSourceFromClient(URL inputUrl) {
		super(inputUrl);
		this.urlString = inputUrl.toString();
		this.client = HttpClients.createDefault();
	}
	
	/**
	 * Gets the HTTP status code.
	 * @return The status code.
	 */
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
			result = STATUS_CODE_STRING + httpStatus;
		}
		catch(HttpResponseException e) {
			result = "Check if website exists" + STATUS_CODE_STRING + httpStatus;

		}
		catch(ClientProtocolException e) {
			result = "Http protocol error encountered" + STATUS_CODE_STRING + httpStatus;
		}
		catch(IOException e) {
			result = "Check internet connection" + STATUS_CODE_STRING + httpStatus;
		}
		
	}
}
