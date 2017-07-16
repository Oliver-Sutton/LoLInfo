package com.oliversutton.lolinfo;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DisplaySummonerInformation {

	private static JPanel _panelInfo;
	private static JPanel _panelSearchGame;
	private static JLabel _lblName;
	private static JLabel _lblLevel;
	private static JLabel _lblRank;
	private static JLabel _lblLeaguePoints;
	private static JLabel _lblRankedLeague;
	private static JLabel _lblIconImage;
	
	public DisplaySummonerInformation(JPanel panelInfo, JPanel panelSearchGame,JLabel lblName, JLabel lblLevel, JLabel lblRank, JLabel lblLeaguePoints, JLabel lblRankedLeague, JLabel lblIconImage) {
		
		_panelInfo = panelInfo;
		_panelSearchGame = panelSearchGame;
		_lblName = lblName;
		_lblLevel = lblLevel;
		_lblRank = lblRank;
		_lblLeaguePoints = lblLeaguePoints;
		_lblRankedLeague = lblRankedLeague;
		_lblIconImage = lblIconImage;
		
	}
	
	public static void fillInformation() {
		
		String[] rankedInformation = {};
		
		try {
			getRankedInformation rankedInfo = new getRankedInformation();
			rankedInformation = rankedInfo.getInfo(SummonerInfo.getSummonerId());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		_lblName.setText("Name: " + SummonerInfo.getName());
		_lblLevel.setText("Level: " + SummonerInfo.getLevel());
		_lblRank.setText("Rank: " + rankedInformation[0] + " " + rankedInformation[1]);
		_lblLeaguePoints.setText("LP: " + rankedInformation[3]);
		_lblRankedLeague.setText("League: " + rankedInformation[2]);
		
		
		if(rankedInformation[0].equals(null)) {
			displayRankedIcon.drawImages("provisional", "i", _lblIconImage);
		} else {
			displayRankedIcon.drawImages(rankedInformation[0], rankedInformation[1], _lblIconImage);
		}
		
		
		_panelInfo.setVisible(true);
		_panelSearchGame.setVisible(true);
		
	}
	
}
