package com.oliversutton.lolinfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class SearchForMatch implements ActionListener{
	
	// summoner spell link http://ddragon.leagueoflegends.com/cdn/6.24.1/img/spell/ + imageName.png
	
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
		
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String returnedInfo;
		
		while((returnedInfo = in.readLine()) != null) {
			JSONParser parser = new JSONParser();
			try {
				Object object = parser.parse(returnedInfo);
				
				JSONObject jsonObject = (JSONObject)object;
				
				System.out.println(jsonObject.get("gameMode") + " " + jsonObject.get("gameType"));
				
				JSONArray playerArray = (JSONArray)jsonObject.get("participants");
				
				for(int i = 0; i != playerArray.toArray().length; i++) {
					JSONObject playerInfo = (JSONObject)playerArray.get(i);
					
					String summonerName = (String) playerInfo.get("summonerName");
					Long summonerId = (Long) playerInfo.get("summonerId");
					Long summonerSpell1 = (Long) playerInfo.get("spell1Id");
					Long summonerSpell2 = (Long) playerInfo.get("spell2Id");
					Long summonerChampion = (Long) playerInfo.get("championId");
					Long summonerTeam = (Long) playerInfo.get("teamId");
					
					getRankedInformation rankedInfo = new getRankedInformation();
					String[] rankedInformation = rankedInfo.getInfo(summonerId);
					
					System.out.println(rankedInformation[0] + "_" + rankedInformation[1]  + ".png");
					System.out.println(summonerName + " " + summonerChampion + " " + summonerSpell1 + " " + summonerSpell2 + " " + summonerTeam);
				}
				
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
}
