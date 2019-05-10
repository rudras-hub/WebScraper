package controller;

import java.util.ArrayList;

public class WSController extends AbstractController {
	
	private static final String SET_URL_METHOD = "setActionURL";
	
	private static final String SET_RESULT_METHOD = "setActionResult";
	
	private static final String SET_RESPONSE_METHOD = "setActionResponse";
	
	private static final String EXECUTE_ACTION_METHOD = "executeAction";
	
	private static final String CLEAR_PAGE_METHOD = "clearPage";
	
	public WSController() {
		super();
	}
	
	public void updateAddress(String newUrl) {
		invokeModelMethod(SET_URL_METHOD, newUrl);
	}
	
	public void updateResult(String newResultText) {
		invokeModelMethod(SET_RESULT_METHOD, newResultText);
	}
	
	public void updateResponse(ArrayList<String> newResponse) 
	{
		invokeModelMethod(SET_RESPONSE_METHOD, newResponse);
	}
	
	public void executeAction() {
		invokeModelMethod(EXECUTE_ACTION_METHOD, null);
	}

}
