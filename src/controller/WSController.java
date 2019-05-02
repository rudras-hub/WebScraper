package controller;

public class WSController extends AbstractController {
	
	private static final String SET_URL_METHOD = "setActionURL";
	
	private static final String SET_RESULT_METHOD = "setActionResult";
	
	private static final String EXECUTE_ACTION_METHOD = "executeAction";
	
	public WSController() {
		super();
	}
	
	public void changeURL(String inputUrl) {
		setModelProperty(SET_URL_METHOD, inputUrl);
	}
	
	public void changeResult(String resultText) {
		setModelProperty(SET_RESULT_METHOD, resultText);
	}
	
	public void executeAction() {
		setModelProperty(EXECUTE_ACTION_METHOD, "");
	}

}
