package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.*;

public class ExecuteActionListener implements ActionListener {
	
	private WSController controller;
	
	private String address;
	
	public ExecuteActionListener(WSController c, String siteAddress) {
		this.controller = c;
		this.address = siteAddress;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		controller.changeURL(address);
		controller.executeAction();
		
	}

}
