package com.oliversutton.lolinfo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoLInfoUI {

	private JFrame frmLolinfo;
	private JTextField txtSummonerName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoLInfoUI window = new LoLInfoUI();
					window.frmLolinfo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoLInfoUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmLolinfo = new JFrame();
		frmLolinfo.setTitle("LoLInfo");
		frmLolinfo.setBounds(100, 100, 450, 300);
		frmLolinfo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLolinfo.getContentPane().setLayout(null);
		
		JPanel panelSearch = new JPanel();
		panelSearch.setBounds(86, 11, 309, 53);
		frmLolinfo.getContentPane().add(panelSearch);
		panelSearch.setLayout(null);
		
		txtSummonerName = new JTextField();
		txtSummonerName.setBounds(10, 23, 126, 20);
		panelSearch.add(txtSummonerName);
		txtSummonerName.setToolTipText("");
		txtSummonerName.setColumns(10);
		
		JComboBox<?> comboRegion = new JComboBox();
		comboRegion.setBounds(146, 23, 54, 20);
		panelSearch.add(comboRegion);
		comboRegion.setModel(new DefaultComboBoxModel(new String[] {"EUW", "NA"}));
		comboRegion.setSelectedIndex(0);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new SearchSummoner(comboRegion, txtSummonerName));
		btnSearch.setBounds(210, 22, 89, 22);
		panelSearch.add(btnSearch);
		
		JLabel lblSummonerName = new JLabel("Summoner Name");
		lblSummonerName.setBounds(10, 8, 126, 14);
		panelSearch.add(lblSummonerName);
		
		JLabel lblRegion = new JLabel("Region");
		lblRegion.setBounds(146, 8, 46, 14);
		panelSearch.add(lblRegion);
		
		JPanel panelLogo = new JPanel();
		panelLogo.setBounds(10, 11, 57, 53);
		frmLolinfo.getContentPane().add(panelLogo);
		panelLogo.setLayout(null);
		
		JLabel lblTitleInfo = new JLabel("Info");
		lblTitleInfo.setVerticalAlignment(SwingConstants.TOP);
		lblTitleInfo.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTitleInfo.setBounds(11, 25, 43, 25);
		panelLogo.add(lblTitleInfo);
		
		JLabel lblTitleLoL = new JLabel("LoL");
		lblTitleLoL.setVerticalAlignment(SwingConstants.TOP);
		lblTitleLoL.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTitleLoL.setBounds(16, 5, 33, 21);
		panelLogo.add(lblTitleLoL);
	}
}
