package io.ztech.music.dao;

import org.json.JSONArray;

import io.ztech.music.util.Browser;

public class FanInfoDao {
	private Browser browser;
	
	public FanInfoDao() {
		this.browser = new Browser();
	}
	public Browser getBrowser() {
		return browser;
	}

	public void setBrowser(Browser browser) {
		this.browser = browser;
	}
	
	public JSONArray getTopFans(int limit) {
		final String POST_URL = "http://localhost:8080/MusicJ2EEBackEnd/GetTopFans";
		final String POST_PARAMS = "limit="+limit;
		return new JSONArray(this.browser.getResponseFromUrl(POST_URL, POST_PARAMS));
	}
	

}
