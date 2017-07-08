package com.oliversutton.lolinfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class SearchSummoner implements ActionListener{
	
	private JComboBox<?> comboRegion;
	private JTextField txtSummonerName;
	private JLabel lblUserFeedback;
	
	// Gets the 3 elements that will be needed to search summoner id and also allow for user feedback.
	public SearchSummoner(JComboBox<?> comboRegion, JTextField txtSummonerName, JLabel lblUserFeedback) {
		this.comboRegion = comboRegion;
		this.txtSummonerName = txtSummonerName;
		this.lblUserFeedback = lblUserFeedback;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (this.txtSummonerName.getText().isEmpty()) {
			this.lblUserFeedback.setText("Please give a summoner name."); // Gives the user feedback, telling them they need to enter a name.
			return;
		} else if (this.comboRegion.getSelectedItem() == "Select Region") {
			this.lblUserFeedback.setText("Please select a region."); // Gives the user feedback, telling them they need to select a region.
			return;
		}
		this.lblUserFeedback.setText(""); // resets text to blank if conditions are met and it had alreayd been triggered.
	}
	
}
