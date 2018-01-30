package io.ztech.music.dao;

import org.json.JSONArray;

import io.ztech.music.util.Browser;

public class ArtistProfilesDao {
	private Browser browser;
	
	public ArtistProfilesDao() {
		this.browser = new Browser();
	}
	public Browser getBrowser() {
		return browser;
	}

	public void setBrowser(Browser browser) {
		this.browser = browser;
	}

	public JSONArray getAllArtistProfile() {
		final String POST_URL = "http://localhost:8080/MusicJ2EEBackEnd/artistList";
		String response =browser.getResponseFromUrl(POST_URL);
		return new JSONArray(response);
	}
}

