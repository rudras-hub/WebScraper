package controller;

import java.util.ArrayList;

/**
 * Controller  class for web-scraper
 * @author suchi
 */
public class WSController extends AbstractController {
	
	private static final String SET_ACTION_METHOD = "setAction";
	
	private static final String SET_RESULT_METHOD = "setActionResult";
	
	private static final String SET_RESPONSE_METHOD = "setActionResponse";
	
	private static final String EXECUTE_ACTION_METHOD = "executeAction";
	
	/**
	 * Initializes a new instance of WSController.
	 */
	public WSController() {
		super();
	}
	
	/**
	 * Updates the address for a web action. 
	 * @param newUrl The updated URL
	 * @see main.AbstractWebAction
	 */
	public void updateAction(String newUrl) {
		invokeModelMethod(SET_ACTION_METHOD, new String[] {newUrl});
	}
	
	/**
	 * Updates the result of a web action
	 * @param newResultText The updated result text.
	 * @see main.AbstractWebAction
	 */
	public void updateResult(String newResultText) {
		invokeModelMethod(SET_RESULT_METHOD, new String[]{newResultText});
	}
	
	/**
	 * Updates response of a web action
	 * @param newResponse The updated response.
	 * @see main.AbstractWebAction
	 */
	public void updateResponse(ArrayList<String> newResponse) 
	{
		invokeModelMethod(SET_RESPONSE_METHOD, new Object[] {newResponse});
	}
	
	/**
	 * Executes a web action
	 */
	public void executeAction() {
		invokeModelMethod(EXECUTE_ACTION_METHOD, new Object[] {});
	}

}
