package com.oliversutton.lolinfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.json.simple.JSONObject;
import org.json.simple.parser.*;


public class SearchSummoner implements ActionListener{
	
	private JComboBox<?> comboRegion;
	private JTextField txtSummonerName;
	private JLabel lblUserFeedback;
	private String apiKey = getApiKey();
	
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
		this.lblUserFeedback.setText(""); // resets text to blank if conditions are met and it had already been triggered.
		try {
			getSummonerId(this.txtSummonerName.getText());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	private String getApiKey(){
		String filePath = "D:\\Java\\LoLInfo\\apiKey.txt";
		String apiKey = "";
		BufferedReader readerBuffer = null;
		try { readerBuffer = new BufferedReader(new FileReader(filePath)); } catch (FileNotFoundException e) { e.printStackTrace(); }
		try { apiKey = readerBuffer.readLine(); } catch (IOException e) { e.printStackTrace(); }
		try { readerBuffer.close(); } catch (IOException e) { e.printStackTrace(); }
		return apiKey;
	}
	
	private void getSummonerId(String summonerName) throws IOException{
		
		String server;
		
		switch ((String)this.comboRegion.getSelectedItem()) {
		case "EUW":
			server = "euw1";
			break;
		case "NA":
			server = "na";
			break;
		default:
			server = "euw1";
			break;
		}
		
		String requestString = "https://" + server + ".api.riotgames.com/lol/summoner/v3/summoners/by-name/" 
								+ this.txtSummonerName.getText() + "?api_key=" + this.apiKey;
		
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
				
				String name = (String) jsonObject.get("name");
				long level = (long) jsonObject.get("summonerLevel");
				long summonerId = (long) jsonObject.get("id");
				long accountId = (long) jsonObject.get("accountId");
				
				System.out.println(name + " " + level);
				
				SummonerInfo.setName(name);
				SummonerInfo.setLevel(level);
				SummonerInfo.setSummonerId(summonerId);
				SummonerInfo.setAccountId(accountId);
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		in.close();
		
		DisplaySummonerInformation.fillInformation();
		
	} 
}
