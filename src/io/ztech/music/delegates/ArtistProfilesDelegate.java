package io.ztech.music.delegates;

import java.util.ArrayList;

import org.json.JSONArray;

import io.ztech.music.beans.ArtistProfilesBean;
import io.ztech.music.dao.ArtistProfilesDao;
public class ArtistProfilesDelegate {
	private ArtistProfilesDao dao;
	
	public ArtistProfilesDelegate() {
		this.dao = new ArtistProfilesDao();
	}
	public ArtistProfilesDao getDao() {
		return dao;
	}

	public void setDao(ArtistProfilesDao dao) {
		this.dao = dao;
	}
	
	public ArrayList<ArtistProfilesBean> getAllArtistProfiles() {
		JSONArray jprofiles = dao.getAllArtistProfile();
		ArrayList<ArtistProfilesBean> profiles = new ArrayList<ArtistProfilesBean>();
		for(int i = 0 ;i < jprofiles.length() ; i++) {
			ArtistProfilesBean profile = new ArtistProfilesBean(jprofiles.getJSONObject(i));
			profiles.add(profile);
		}
		return profiles;
	}
	
}
