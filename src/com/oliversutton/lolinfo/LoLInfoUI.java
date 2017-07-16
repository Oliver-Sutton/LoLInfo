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
		frmLolinfo.setBounds(100, 100, 864, 542);
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
		
		// Add actionListeners to components.
		btnSearch.addActionListener(new SearchSummoner(comboRegion, txtSummonerName, lblUserFeedback));
		
		JPanel panelMatchInfo = new JPanel();
		panelMatchInfo.setBounds(10, 11, 828, 481);
		frmLolinfo.getContentPane().add(panelMatchInfo);
		panelMatchInfo.setLayout(null);
		
		JLabel lblTeam21 = new JLabel("Team 2 Player 1");
		lblTeam21.setBounds(45, 456, 84, 14);
		panelMatchInfo.add(lblTeam21);
		
		JLabel lblTeam22 = new JLabel("Team 2 Player 2");
		lblTeam22.setBounds(192, 456, 84, 14);
		panelMatchInfo.add(lblTeam22);
		
		JLabel lblTeam23 = new JLabel("Team 2 Player 3");
		lblTeam23.setBounds(369, 456, 84, 14);
		panelMatchInfo.add(lblTeam23);
		
		JLabel lblTeam24 = new JLabel("Team 2 Player 4");
		lblTeam24.setBounds(545, 456, 84, 14);
		panelMatchInfo.add(lblTeam24);
		
		JLabel lblTeam25 = new JLabel("Team 2 Player 5");
		lblTeam25.setBounds(699, 456, 84, 14);
		panelMatchInfo.add(lblTeam25);
		
		JLabel lblTeam11 = new JLabel("Team 1 Player 1");
		lblTeam11.setBounds(45, 215, 84, 14);
		panelMatchInfo.add(lblTeam11);
		
		JLabel lblTeam12 = new JLabel("Team 1 Player 2");
		lblTeam12.setBounds(192, 215, 84, 14);
		panelMatchInfo.add(lblTeam12);
		
		JLabel lblTeam13 = new JLabel("Team 1 Player 3");
		lblTeam13.setBounds(369, 215, 84, 14);
		panelMatchInfo.add(lblTeam13);
		
		JLabel lblTeam14 = new JLabel("Team 1 Player 4");
		lblTeam14.setBounds(545, 215, 84, 14);
		panelMatchInfo.add(lblTeam14);
		
		JLabel lblTeam15 = new JLabel("Team 1 Player 5");
		lblTeam15.setBounds(699, 215, 84, 14);
		panelMatchInfo.add(lblTeam15);
		
		JLabel lblChampion11 = new JLabel("Team 1 Champion 1");
		lblChampion11.setBounds(37, 200, 99, 14);
		panelMatchInfo.add(lblChampion11);
		
		JLabel lblChampion12 = new JLabel("Team 1 Champion 2");
		lblChampion12.setBounds(184, 200, 99, 14);
		panelMatchInfo.add(lblChampion12);
		
		JLabel lblChampion13 = new JLabel("Team 1 Champion 3");
		lblChampion13.setBounds(358, 200, 99, 14);
		panelMatchInfo.add(lblChampion13);
		
		JLabel lblChampion14 = new JLabel("Team 1 Champion 4");
		lblChampion14.setBounds(536, 200, 99, 14);
		panelMatchInfo.add(lblChampion14);
		
		JLabel lblChampion15 = new JLabel("Team 1 Champion 5");
		lblChampion15.setBounds(690, 200, 99, 14);
		panelMatchInfo.add(lblChampion15);
		
		JLabel lblChampion21 = new JLabel("Team 2 Champion 1");
		lblChampion21.setBounds(37, 439, 99, 14);
		panelMatchInfo.add(lblChampion21);
		
		JLabel lblChampion22 = new JLabel("Team 2 Champion 2");
		lblChampion22.setBounds(184, 439, 99, 14);
		panelMatchInfo.add(lblChampion22);
		
		JLabel lblChampion23 = new JLabel("Team 2 Champion 3");
		lblChampion23.setBounds(358, 439, 99, 14);
		panelMatchInfo.add(lblChampion23);
		
		JLabel lblChampion24 = new JLabel("Team 2 Champion 4");
		lblChampion24.setBounds(536, 439, 104, 14);
		panelMatchInfo.add(lblChampion24);
		
		JLabel lblChampion25 = new JLabel("Team 2 Champion 5");
		lblChampion25.setBounds(686, 439, 103, 14);
		panelMatchInfo.add(lblChampion25);
		
		// display search game panel.
		
		JPanel panelSearchForGame = new JPanel();
		panelSearchForGame.setBounds(143, 143, 125, 53);
		panelMatchInfo.add(panelSearchForGame);
		panelSearchForGame.setVisible(false);
		
		JLabel lblTitleSearchMatch = new JLabel("Search For a Game");
		panelSearchForGame.add(lblTitleSearchMatch);
		lblTitleSearchMatch.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnSearchForMatch = new JButton("Search");
		panelSearchForGame.add(btnSearchForMatch);
		btnSearchForMatch.addActionListener(new SearchForMatch());
		
		// Give access to labels in another classes.
		new DisplaySummonerInformation(panelSummonerInformation, panelSearchForGame, lblName, lblLevel, lblRank, lblLeaguePoints, lblRankedLeague, lblIconImage);
		
	}
}
