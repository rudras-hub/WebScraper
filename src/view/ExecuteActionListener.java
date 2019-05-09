package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.text.JTextComponent;

import controller.*;

public class ExecuteActionListener implements ActionListener {
	
	private WSController controller;
	
	private JTextComponent textComponent;
	
	public ExecuteActionListener(WSController c, JTextComponent addressComponent) {
		this.controller = c;
		this.textComponent = addressComponent;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String newAddress = textComponent.getText();
		controller.updateAddress(newAddress);
		controller.clearPage();
		controller.executeAction();
		
	}

}
