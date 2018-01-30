package io.ztech.music.dao;
import org.json.JSONArray;

import io.ztech.music.util.Browser;

public class FanTrackDao {
	private Browser browser;
	
	public FanTrackDao() {
		this.browser = new Browser();
	}
	public Browser getBrowser() {
		return browser;
	}

	public void setBrowser(Browser browser) {
		this.browser = browser;
	}

	public JSONArray getFanCounts(int profileId) {
		final String POST_URL = "http://localhost:8080/MusicJ2EEBackEnd/FanTracker";
		final String POST_PARAMS = "profileId="+profileId;
		return new JSONArray(this.browser.getResponseFromUrl(POST_URL, POST_PARAMS));
	}
	
	public JSONArray getAllProfileFanCounts() {
		final String POST_URL = "http://localhost:8080/MusicJ2EEBackEnd/FanTrackerMain";
		return new JSONArray(this.browser.getResponseFromUrl(POST_URL));
	}
}
