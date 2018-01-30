package io.ztech.music.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class Browser {
	public String getResponseFromUrl(String POST_URL, String POST_PARAMS) {
		final String USER_AGENT = "Mozilla/5.0";
		try {
			URL obj = new URL(POST_URL);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", USER_AGENT);
			con.setDoOutput(true);
			if (POST_PARAMS != null) {
				String postParams = POST_PARAMS;
				// For POST only - START
				OutputStream os = con.getOutputStream();
				os.write(postParams.getBytes());
				os.flush();
				os.close();
			}
			int responseCode = con.getResponseCode();

			if (responseCode == HttpURLConnection.HTTP_OK) { // success
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
				return response.toString();
			} else {
				System.out.println("POST request not worked");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getResponseFromUrl(String POST_URL) {
		final String USER_AGENT = "Mozilla/5.0";
		try {
			URL obj = new URL(POST_URL);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", USER_AGENT);
			con.setDoOutput(true);
			int responseCode = con.getResponseCode();

			if (responseCode == HttpURLConnection.HTTP_OK) { // success
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
				return response.toString();
			} else {
				System.out.println("POST request not worked");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
