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
import java.awt.Color;

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
	 * Initialise the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		
		frmLolinfo = new JFrame();
		frmLolinfo.setTitle("LoLInfo");
		frmLolinfo.setBounds(100, 100, 466, 272);
		frmLolinfo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLolinfo.getContentPane().setLayout(null);
		
		JPanel panelSearch = new JPanel();
		panelSearch.setBounds(77, 11, 360, 60);
		frmLolinfo.getContentPane().add(panelSearch);
		panelSearch.setLayout(null);
		
		txtSummonerName = new JTextField();
		txtSummonerName.setBounds(10, 23, 126, 20);
		panelSearch.add(txtSummonerName);
		txtSummonerName.setToolTipText("");
		txtSummonerName.setColumns(10);
		
		JComboBox<?> comboRegion = new JComboBox();
		comboRegion.setBounds(146, 23, 107, 20);
		panelSearch.add(comboRegion);
		comboRegion.setModel(new DefaultComboBoxModel(new String[] {"Select Region", "EUW", "NA"}));
		comboRegion.setSelectedIndex(0);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(263, 22, 87, 22);
		panelSearch.add(btnSearch);
		
		JLabel lblSummonerName = new JLabel("Summoner Name");
		lblSummonerName.setBounds(10, 8, 126, 14);
		panelSearch.add(lblSummonerName);
		
		JLabel lblRegion = new JLabel("Region");
		lblRegion.setBounds(146, 8, 46, 14);
		panelSearch.add(lblRegion);
		
		JLabel lblUserFeedback = new JLabel("");
		lblUserFeedback.setForeground(Color.RED);
		lblUserFeedback.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserFeedback.setBounds(0, 45, 360, 14);
		panelSearch.add(lblUserFeedback);
		
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
		
		// display summoner information panel.
		
		JPanel panelSummonerInformation = new JPanel();
		panelSummonerInformation.setBounds(10, 82, 427, 73);
		frmLolinfo.getContentPane().add(panelSummonerInformation);
		panelSummonerInformation.setLayout(null);
		panelSummonerInformation.setVisible(false);
		
		JLabel lblLevel = new JLabel("Level:");
		lblLevel.setBounds(10, 28, 181, 14);
		panelSummonerInformation.add(lblLevel);
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setBounds(10, 11, 181, 14);
		panelSummonerInformation.add(lblName);
		
		JLabel lblRank = new JLabel("Rank:");
		lblRank.setBounds(186, 11, 171, 14);
		panelSummonerInformation.add(lblRank);
		
		JLabel lblLeaguePoints = new JLabel("LP:");
		lblLeaguePoints.setBounds(186, 28, 171, 14);
		panelSummonerInformation.add(lblLeaguePoints);
		
		JLabel lblRankedLeague = new JLabel("League:");
		lblRankedLeague.setBounds(186, 44, 171, 14);
		panelSummonerInformation.add(lblRankedLeague);
		
		JLabel lblIconImage = new JLabel("");
		lblIconImage.setBounds(367, 11, 50, 50);
		panelSummonerInformation.add(lblIconImage);
		
		// display search game panel.
		
		JPanel panelSearchForGame = new JPanel();
		panelSearchForGame.setBounds(157, 166, 125, 53);
		frmLolinfo.getContentPane().add(panelSearchForGame);
		panelSearchForGame.setVisible(false);
		
		JLabel lblTitleSearchMatch = new JLabel("Search For a Game");
		panelSearchForGame.add(lblTitleSearchMatch);
		lblTitleSearchMatch.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnSearchForMatch = new JButton("Search");
		panelSearchForGame.add(btnSearchForMatch);
		btnSearchForMatch.addActionListener(new SearchForMatch());
		
		// Give access to labels in another classes.
		new DisplaySummonerInformation(panelSummonerInformation, panelSearchForGame, lblName, lblLevel, lblRank, lblLeaguePoints, lblRankedLeague, lblIconImage);
		
		// Add actionListeners to components.
		btnSearch.addActionListener(new SearchSummoner(comboRegion, txtSummonerName, lblUserFeedback));
		
		
		
	}
}
