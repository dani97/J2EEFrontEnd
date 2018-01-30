package io.ztech.music.delegates;

import org.json.JSONArray;
import org.json.JSONObject;

import io.ztech.music.dao.FanTrackDao;

public class FanTrackDelegate {
	private FanTrackDao fanDao;
	
	public FanTrackDelegate() {
		this.fanDao = new FanTrackDao();
	}
	
	public FanTrackDao getFanDao() {
		return fanDao;
	}

	public void setFanDao(FanTrackDao fanDao) {
		this.fanDao = fanDao;
	}

	public JSONObject getFanCountChart(int profileId,String chartType) {
		JSONArray fanTrackDetails = this.fanDao.getFanCounts(profileId);
		JSONObject fanChart = new JSONObject();
		fanChart.put("data", fanTrackDetails);
		fanChart.put("type", chartType);
		fanChart.put("x", "queryDate");
		fanChart.put("y", "fanCount");
		fanChart.put("color", "queryDate");
		return fanChart;
	}
	
	public JSONObject getAllProfileFanChart() {
		JSONArray fanTrackDetails = this.fanDao.getAllProfileFanCounts();
		JSONObject fanChart = new JSONObject();
		fanChart.put("data", fanTrackDetails);
		fanChart.put("type", "line");
		fanChart.put("x", "queryDate");
		fanChart.put("y", "fanCount");
		fanChart.put("color", "profileId");
		return fanChart;
	}
}
