package io.ztech.music.dao;

import org.json.JSONArray;
import org.json.JSONObject;

import io.ztech.music.beans.RecordsBean;
import io.ztech.music.util.Browser;

public class RecordsDao {
	private Browser browser;
	
	public RecordsDao() {
		this.browser = new Browser();
	}
	public Browser getBrowser() {
		return browser;
	}

	public void setBrowser(Browser browser) {
		this.browser = browser;
	}
	
	public JSONArray getAllRecords() {
		final String POST_URL = "http://localhost:8080/MusicJ2EEBackEnd/RecordList";
		return new JSONArray(this.browser.getResponseFromUrl(POST_URL));
	}
	
	public JSONObject insertRecord(RecordsBean record) {
		final String POST_URL = "http://localhost:8080/MusicJ2EEBackEnd/AddRecord";
		final String POST_PARAMS = "recordName="+record.getRecordName()+"&soldCopies="+record.getSoldCopies()+
				"&releaseDate="+record.getReleaseDate()+"&recordType="+record.getRecordType();
		return new JSONObject(this.browser.getResponseFromUrl(POST_URL, POST_PARAMS));
	}
}
