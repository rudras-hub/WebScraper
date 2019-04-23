package view;

import java.awt.Color;
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
	
	public WSView() {
		Initialize();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void OnPropertyChange(PropertyChangeEvent event) {
		// TODO Auto-generated method stub
	}
	
	public void Initialize() {
		JPanel panel = new JPanel(); 
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		panel.setBackground(Color.GRAY);
		
		JTextField addressText = new JTextField("Enter website here"); 
		constraints.gridx = 0;
		constraints.gridy = 0; 
		constraints.gridwidth = 2;
		constraints.weightx = 0.25;
		constraints.weighty = 0.25;
		constraints.fill = GridBagConstraints.HORIZONTAL; 
		panel.add(addressText, constraints); 
		
		JButton goButton = new JButton("Go");
		goButton.setBackground(Color.green);
		goButton.setOpaque(true);
		constraints.gridx = 2; 
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.weightx = 0.25;
		constraints.weighty = 0.25;
		constraints.fill = GridBagConstraints.CENTER;
		panel.add(goButton, constraints);
		
		JTextArea responseTextArea = new JTextArea();
		responseTextArea.setEditable(false);
		JScrollPane responseScrollPane = new JScrollPane(responseTextArea);
		JLabel responseLabel = new JLabel(" Response ");
		responseLabel.setLabelFor(responseTextArea);
		responseLabel.setOpaque(false);
		constraints.gridx = 0; 
		constraints.gridy = 1; 
		constraints.gridwidth = 3; 
		constraints.gridheight = 3;
		constraints.weightx = 0.75;
		constraints.weighty = 0.75;
		constraints.fill = GridBagConstraints.BOTH;
		panel.add(responseScrollPane, constraints);
		
		JTextField resultTextField = new JTextField();
		resultTextField.setEditable(false);
		JLabel resultLabel = new JLabel(" Result ");
		resultLabel.setLabelFor(resultTextField);
		resultLabel.setOpaque(false);
		constraints.gridx = 0; 
		constraints.gridy = 5;
		constraints.gridwidth = 3;
		constraints.gridheight = 1;
		constraints.weightx = 0;
		constraints.weighty = 0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		panel.add(resultTextField, constraints);
		
		add(panel);
		pack();
		setSize(500, 500);
		setVisible(true);
		
	}

	

}
