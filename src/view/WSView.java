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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import controller.*;

/**
 * Defines the View for web scraper.
 * @author suchi
 *
 */
public class WSView extends JFrame implements View {
	
	/**
	 * Action listener for the Go button.
	 * @author suchi
	 *
	 */
	private class GoActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String newAddress = addressText.getText();
			controller.updateAction(newAddress);
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
	
	private JButton goButton; 
	
	private JLabel responseLabel; 
	
	private JLabel resultLabel; 
	
	private JTextArea responseTextArea;
	
	private GridBagConstraints constraints;
	
	private WSController controller;
	
	/**
	 * Initializes the View
	 * @param wsController
	 */
	public WSView(WSController wsController) {
		this.panel = new JPanel();
		this.addressText = new JTextField("www.google.com");
		this.resultTextField = new JTextField();
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
		Color backgroundColor = new Color(24, 98, 163); // 
		Color textColor = new Color(255, 165, 0);
		
		panel.setLayout(new GridBagLayout());
		panel.setBackground(backgroundColor);
		
		// Address Text
		setDimensions(3, 1);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		addComponent(addressText, 1, 0);
		
		// Go button
		goButton.setForeground(textColor);
		setDimensions(1, 1);
		constraints.fill = GridBagConstraints.NONE;
		addComponent(goButton, 4, 0);
		goButton.addActionListener(new GoActionListener());
		
		// Response Label
		responseLabel.setForeground(textColor);
		setPadding(10,0);
		addComponent(responseLabel, 0, 4);
		
		// Response Text Area
		responseTextArea.setEditable(false);
		JScrollPane responseScrollPane = new JScrollPane(responseTextArea);
		constraints.fill = GridBagConstraints.BOTH; 
		setDimensions(3, 3);
		setPadding(500, 500);
		addComponent(responseScrollPane, 1, 2);
		
		// Result Label
		resultLabel.setForeground(textColor);
		constraints.fill = GridBagConstraints.NONE;
		setDimensions(1, 1);
		setPadding(0,0);
		addComponent(resultLabel, 0, 6);
		
		// Result Text
		resultTextField.setEditable(false);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		setDimensions(3, 1);
		addComponent(resultTextField, 1, 6);
	}
	
	private void initializeFrame() {
		setSize(700, 700);
		setTitle("WebScraper");
		setIconImage(new ImageIcon("scraper.jpg").getImage());
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
