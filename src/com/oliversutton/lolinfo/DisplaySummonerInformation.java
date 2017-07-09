package com.oliversutton.lolinfo;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DisplaySummonerInformation {

	private static JPanel _panelInfo;
	private static JLabel _lblName;
	private static JLabel _lblLevel;
	private static JLabel _lblRank;
	private static JLabel _lblLeaguePoints;
	private static JLabel _lblRankedLeague;
	
	public DisplaySummonerInformation(JPanel panelInfo, JLabel lblName, JLabel lblLevel, JLabel lblRank, JLabel lblLeaguePoints, JLabel lblRankedLeague) {
		
		_panelInfo = panelInfo;
		_lblName = lblName;
		_lblLevel = lblLevel;
		_lblRank = lblRank;
		_lblLeaguePoints = lblLeaguePoints;
		_lblRankedLeague = lblRankedLeague;
		
	}
	
	public static void fillInformation() {
		
		String[] rankedInformation = {};
		
		try {
			rankedInformation = getRankedInformation.getInfo(SummonerInfo.getSummonerId());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		_lblName.setText("Name: " + SummonerInfo.getName());
		_lblLevel.setText("Level: " + SummonerInfo.getLevel());
		_lblRank.setText("Rank: " + rankedInformation[0] + " " + rankedInformation[1]);
		_lblLeaguePoints.setText("LP: " + rankedInformation[3]);
		_lblRankedLeague.setText("League: " + rankedInformation[2]);
		
		
		_panelInfo.setVisible(true);
	}
	
}
