package in.ptp.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import in.ptp.messenger.database.DatabaseClass;
import in.ptp.messenger.model.Profile;

public class ProfileService {
	
	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService () {
		profiles.put("raj1", new Profile(1L, "raj1", "raj", "k"));
		profiles.put("rajk1", new Profile(2L, "rajk1", "rajk", "KR"));
	}

	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if (profile.getProfileName().isEmpty()) {
			System.out.println("null");
			return null;
		} 
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}
	

}
