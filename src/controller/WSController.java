package controller;

public class WSController extends AbstractController {
	
	private static final String MODEL_URL_PROPERTY = "actionURL";
	
	private static final String MODEL_RESULT_PROPERTY = "actionResult";
	
	public WSController() {
		super();
	}
	
	public void changeURL(String inputUrl) {
		setModelProperty(MODEL_URL_PROPERTY, inputUrl);
	}
	
	public void changeResult(String resultText) {
		setModelProperty(MODEL_RESULT_PROPERTY, resultText);
	}

}
