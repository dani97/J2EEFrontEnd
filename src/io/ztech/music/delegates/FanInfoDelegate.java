package io.ztech.music.delegates;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import io.ztech.music.dao.FanInfoDao;
import io.ztech.music.util.Mailer;

public class FanInfoDelegate {
	private FanInfoDao dao;
	public FanInfoDelegate() {
		this.dao = new FanInfoDao();
	}

	public FanInfoDao getDao() {
		return dao;
	}

	public void setDao(FanInfoDao dao) {
		this.dao = dao;
	}
	
	public boolean giftFans(HttpServletRequest request, HttpServletResponse response) {
		Mailer mailer = new Mailer();
		JSONArray topFans = dao.getTopFans(Integer.parseInt(request.getParameter("limit")));
		String record = request.getParameter("record");
		InputStream input = getClass().getResourceAsStream("/io/ztech/music/properties/twitterconfig.properties");
		Properties prop = new Properties();
		try {
			prop.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String from = prop.getProperty("email");
		String password = prop.getProperty("password");
		String sub = "Greetings from EFMusic";
		String msg = "Happy Holidays, Enjoy my new Record : "+record;
		for(int i = 0 ; i < topFans.length() ; i++) {
			JSONObject fan = topFans.getJSONObject(i);
			String to = fan.getString("email");
			mailer.send(from, password, to, sub, msg);
		}
		return true;
	}
	
}
