package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import controller.*;

/**
 * Defines the View for web scraper.
 * @author Suchi
 *
 */
public class WSView extends JFrame implements View {
	
	/**
	 * Action listener for the Go button.
	 * @author Suchi
	 *
	 */
	private class GoActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String newAddress = addressText.getText();
			controller.updateAddress(newAddress);
			clearPage();
			controller.executeAction();
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panel;
	
	private JTextField addressText;
	
	private JTextField resultTextField;
	
	private JComboBox<String> actionComboBox;
	
	private JButton goButton; 
	
	private JLabel responseLabel; 
	
	private JLabel resultLabel; 
	
	private JTextArea responseTextArea;
	
	private GridBagConstraints constraints;
	
	private Color backgroundColor = new Color(255, 190, 130);
	
	private Color textColor = new Color(0, 80, 155);
	
	private String[] actionOptions = {"View Page Source", "Ping Website"};
	
	private WSController controller;
	
	/**
	 * Initializes the View
	 * @param wsController
	 */
	public WSView(WSController wsController) {
		this.panel = new JPanel();
		this.addressText = new JTextField("www.google.com");
		this.resultTextField = new JTextField();
		this.actionComboBox = new JComboBox<String>(actionOptions);
		this.goButton = new JButton("Go");
		this.responseLabel = new JLabel("Response");
		this.resultLabel = new JLabel("Result");
		this.responseTextArea = new JTextArea();
		this.constraints = new GridBagConstraints();
		this.controller = wsController;
		
		initializeComponent();
		initializeFrame();
		
	}

	@Override
	public void OnPropertyChange(PropertyChangeEvent event) {
		final String ACTION_RESULT_PROPERTY = "actionResult";
		
		final String ACTION_RESPONSE_PROPERTY = "actionResponse";
		
		final String ACTION_URL_PROPERTY = "actionURL";
		
		if(checkEventProperty(event, ACTION_RESULT_PROPERTY)) 
		{
			String newValue = event.getNewValue().toString();
			resultTextField.setText(newValue);
		}
		else if(checkEventProperty(event, ACTION_RESPONSE_PROPERTY)) 
		{
			@SuppressWarnings("unchecked")
			ArrayList<String> newValue = (ArrayList<String>) event.getNewValue();
			for(String line : newValue) 
			{
				responseTextArea.append(line + "\n");
			}
		}
		else if (checkEventProperty(event, ACTION_URL_PROPERTY)) 
		{
			String newValue = event.getNewValue().toString();
			addressText.setText(newValue);			
		}
		
	}
	
	private void initializeComponent() {
		panel.setLayout(new GridBagLayout());
		panel.setBackground(backgroundColor);
		
		// Address Text
		setDimensions(3, 1);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		addComponent(addressText, 1, 0);
		
		// Action Combo Box
		actionComboBox.setForeground(textColor);
		setDimensions(1, 1);
		setPadding(0, 10);
		constraints.fill = GridBagConstraints.NONE;
		addComponent(actionComboBox, 1, 2);
		
		// Go button
		goButton.setForeground(textColor);
		setDimensions(1, 1);
		setPadding(0, 0);
		constraints.fill = GridBagConstraints.EAST;
		addComponent(goButton, 3, 2);
		goButton.addActionListener(new GoActionListener());
		
		// Response Label
		responseLabel.setForeground(textColor);
		constraints.fill = GridBagConstraints.NONE;
		setDimensions(1, 1);
		setPadding(15,0);
		addComponent(responseLabel, 0, 6);
		
		// Response Text Area
		responseTextArea.setEditable(false);
		JScrollPane responseScrollPane = new JScrollPane(responseTextArea);
		constraints.fill = GridBagConstraints.BOTH; 
		setDimensions(3, 3);
		setPadding(500, 500);
		addComponent(responseScrollPane, 1, 4);
		
		// Result Label
		resultLabel.setForeground(textColor);
		constraints.fill = GridBagConstraints.NONE;
		setDimensions(1, 1);
		setPadding(0,0);
		addComponent(resultLabel, 0, 8);
		
		// Result Text
		resultTextField.setEditable(false);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		setDimensions(3, 1);
		addComponent(resultTextField, 1, 8);
	}
	
	private void initializeFrame() {
		setSize(750, 700);
		setTitle("WebScraper");
		setIconImage(new ImageIcon("src/main/resources/scraper.png").getImage());
		setContentPane(panel);
		setVisible(true);
	}
	
	private void addComponent(Component component, int positionX, int positionY) {
		constraints.gridx = positionX;
		constraints.gridy = positionY;
		panel.add(component, constraints);	
	}
	
	private void setDimensions(int width,int height) {
		constraints.gridwidth = width;
		constraints.gridheight = height;
	}
	
	private void setPadding(int padX, int padY) {
		constraints.ipadx = padX;
		constraints.ipady = padY;
	}
	
	private void clearPage() {
		responseTextArea.setText("");
		resultTextField.setText("");
	}
	
	private Boolean checkEventProperty(PropertyChangeEvent event, String propertyName) 
	{
		return event.getPropertyName().equals(propertyName);
	}
}
