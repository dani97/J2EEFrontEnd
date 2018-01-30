package io.ztech.music.delegates;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import io.ztech.music.beans.RecordsBean;
import io.ztech.music.dao.RecordsDao;

public class RecordsDelegate {
	private static Logger logger = Logger.getLogger(RecordsDelegate.class.getName());
	private RecordsDao dao;
	public RecordsDelegate() {
		this.dao = new RecordsDao();
	}
	
	public ArrayList<RecordsBean> getAllRecords(HttpServletRequest request,HttpServletResponse response){
		JSONArray jrecords = dao.getAllRecords();
		ArrayList<RecordsBean> records = new ArrayList<RecordsBean>(); 
		for(int i = 0 ; i < jrecords.length() ; i++ ) {
			RecordsBean bean = new RecordsBean(jrecords.getJSONObject(i));
			records.add(bean);
		}
		return records;
	}
	
	public boolean insertRecord(HttpServletRequest request,HttpServletResponse response) {
		RecordsBean record = new RecordsBean();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		try {
			record.setRecordName(request.getParameter("recordName"));
			record.setReleaseDate(LocalDate.parse(request.getParameter("releaseDate"),formatter));
			record.setSoldCopies(Integer.parseInt(request.getParameter("soldCopies")));
			record.setRecordType(request.getParameter("recordType"));
			JSONObject result = dao.insertRecord(record);
			if(result.getBoolean("result")) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			logger.warning("couldn't parse input");
			e.printStackTrace();
			return false;
		}
	}
}
