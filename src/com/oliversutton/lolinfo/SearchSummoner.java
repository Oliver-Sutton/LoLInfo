package com.oliversutton.lolinfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class SearchSummoner implements ActionListener{
	
	private JComboBox<?> comboRegion;
	private JTextField txtSummonerName;
	
	public SearchSummoner(JComboBox<?> comboRegion, JTextField txtSummonerName) {
		this.comboRegion = comboRegion;
		this.txtSummonerName = txtSummonerName;
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.print(this.txtSummonerName.getText() + "  " + this.comboRegion.getSelectedItem());
	}
	
}
