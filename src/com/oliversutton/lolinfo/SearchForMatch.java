package com.oliversutton.lolinfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class SearchForMatch implements ActionListener{
	
	private String apiKey = ApiKey.getApiKey();
	
	public void actionPerformed(ActionEvent e) {
		try {
			getMatchData();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}
	
	public void getMatchData() throws IOException {
		
		String requestString = "https://" + SummonerInfo.getRegion() + ".api.riotgames.com/lol/spectator/v3/active-games/by-summoner/" 
								+ SummonerInfo.getSummonerId() + "?api_key=" + this.apiKey;
		
		URL url = new URL(requestString);
		URLConnection connection = url.openConnection();
		connection.connect();
		
	}
	
	
	
}
