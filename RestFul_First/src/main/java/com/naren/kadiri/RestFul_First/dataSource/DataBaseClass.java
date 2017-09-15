package com.naren.kadiri.RestFul_First.dataSource;

import java.util.HashMap;
import java.util.Map;

import com.naren.kadiri.RestFul_First.model.Message;
import com.naren.kadiri.RestFul_First.model.Profile;

public class DataBaseClass {

	private static Map<Long, Message> message = new HashMap<Long, Message>();
	private static Map<Long, Profile> profile = new HashMap<Long, Profile>();

	public static Map<Long, Message> getMessage() {
		return message;
	}

	public static void setMessage(Map<Long, Message> message) {
		DataBaseClass.message = message;
	}

	public static Map<Long, Profile> getProfile() {
		return profile;
	}

	public static void setProfile(Map<Long, Profile> profile) {
		DataBaseClass.profile = profile;
	}

}
