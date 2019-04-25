package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.beans.PropertyChangeEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WSView extends JFrame implements View {
	
	private JPanel panel;
	
	private JTextField addressText;
	
	private JTextField resultTextField;
	
	private JButton goButton; 
	
	private JLabel responseLabel; 
	
	private JLabel resultLabel; 
	
	private JTextArea responseTextArea;
	
	private GridBagConstraints constraints;
	
	public WSView() {
		this.panel = new JPanel();
		this.addressText = new JTextField("Enter website here");
		this.resultTextField = new JTextField();
		this.goButton = new JButton("Go");
		this.responseLabel = new JLabel("Response");
		this.resultLabel = new JLabel("Result");
		this.responseTextArea = new JTextArea();
		this.constraints = new GridBagConstraints();
		
		initialize();
		
		setSize(700, 700);
		setContentPane(panel);
		setVisible(true);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void OnPropertyChange(PropertyChangeEvent event) {
		// TODO Auto-generated method stub
	}
	
	public void initialize() {
		panel.setLayout(new GridBagLayout());
		panel.setBackground(Color.GRAY);
		
		// Address Text
		setDimensions(3, 1);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		addComponent(addressText, 1, 0);
		
		// Go button
		goButton.setForeground(Color.BLUE);
		setDimensions(1, 1);
		constraints.fill = GridBagConstraints.NONE;
		addComponent(goButton, 4, 0);
		
		// Response Label
		addComponent(responseLabel, 1, 1);
		
		// Response Text Area
		responseTextArea.setEditable(false);
		JScrollPane responseScrollPane = new JScrollPane(responseTextArea);
		constraints.fill = GridBagConstraints.BOTH; 
		setDimensions(3, 3);
		setPadding(500, 500);
		addComponent(responseScrollPane, 1, 2);
		
		// Result Label
		constraints.fill = GridBagConstraints.NONE;
		setDimensions(1, 1);
		setPadding(0,0);
		addComponent(resultLabel, 1, 6);
		
		// Result Text
		resultTextField.setEditable(false);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		setDimensions(2, 1);
		addComponent(resultTextField, 2, 6);
		

		
	}
	
	private void addComponent(Component component, int positionX, int positionY) {
		constraints.gridx = positionX;
		constraints.gridy = positionY;
		panel.add(component, constraints);	
	}
	
	private void addComponent(Component component, int position, Boolean isX) {
		if(isX) 
		{
			constraints.gridx = position;
			constraints.gridy = GridBagConstraints.RELATIVE;
		}
		else 
		{
			constraints.gridx = GridBagConstraints.RELATIVE;
			constraints.gridy = position;
		}
		
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
}
