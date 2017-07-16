package com.oliversutton.lolinfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class getRankedInformation {

	public String[] getInfo(long summonerId) throws IOException {
		
		String[] rankedInformation = {"","","",""}; // initialise ranked information array to be returned.
		
		
		String requestString = "https://" + SummonerInfo.getRegion() + ".api.riotgames.com/lol/league/v3/positions/by-summoner/"
								+ summonerId + "?api_key=" + ApiKey.getApiKey();
		URL url = new URL(requestString);
		URLConnection connection = url.openConnection();
		connection.connect();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String returnedInfo;
		
		while((returnedInfo = in.readLine()) != null) {
			JSONParser parser = new JSONParser();
			try {
				Object object = parser.parse(returnedInfo);
				
				JSONArray jsonArray = (JSONArray)object;
				JSONObject jsonObject = (JSONObject)jsonArray.get(0);
				
				rankedInformation[0]  = (String)jsonObject.get("tier");
				rankedInformation[1]  = (String)jsonObject.get("rank");
				rankedInformation[2]  = (String)jsonObject.get("leagueName");
				rankedInformation[3]  = jsonObject.get("leaguePoints").toString();
 				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return rankedInformation; // returns ranked information array.
		
	}
	
}
