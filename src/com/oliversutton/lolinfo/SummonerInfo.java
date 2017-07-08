package com.oliversutton.lolinfo;

public class SummonerInfo {

	private static long _summonerId = 0;
	private static long _accountId = 0;
	private static String _name = "";
	private static long _level = 0;
	
	public static void setSummonerId(long summonerId) {
		_summonerId = summonerId;
	}
	
	public static long getSummonerId() {
		return _summonerId;
	}
	
	public static void setAccountId(long accountId) {
		_accountId = accountId;
	}
	
	public static long getAccountId() {
		return _accountId;
	}
	
	public static void setName(String name) {
		_name = name;
	}
	
	public static String getName() {
		return _name;
	}
	
	public static void setLevel(long level) {
		_level = level;
	}
	
	public static long getLevel() {
		return _level;
	}
	
}
