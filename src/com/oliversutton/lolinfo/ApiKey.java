package com.oliversutton.lolinfo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ApiKey {

	public static String getApiKey() {
		
		String filePath = System.getProperty("user.dir") + "\\apiKey.txt";
		String apiKey = "";
		BufferedReader readerBuffer = null;
		try { readerBuffer = new BufferedReader(new FileReader(filePath)); } catch (FileNotFoundException e) { e.printStackTrace(); }
		try { apiKey = readerBuffer.readLine(); } catch (IOException e) { e.printStackTrace(); }
		try { readerBuffer.close(); } catch (IOException e) { e.printStackTrace(); }
		return apiKey;
		
	}
	
}
