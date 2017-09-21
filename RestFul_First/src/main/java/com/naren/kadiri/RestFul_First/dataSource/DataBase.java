package com.naren.kadiri.RestFul_First.dataSource;

import java.util.HashMap;
import java.util.Map;

import com.naren.kadiri.RestFul_First.model.Comment;
import com.naren.kadiri.RestFul_First.model.Message;
import com.naren.kadiri.RestFul_First.model.Profile;

public class DataBase {

	private static Map<Long, Message> message = new HashMap<Long, Message>();
	private static Map<String, Profile> profiles = new HashMap<>();

	public static Map<Long, Message> getMessage() {
		return message;
	}

	public static void setMessage(Map<Long, Message> message) {
		DataBase.message = message;
	}

	public static Map<String, Profile> getProfiles() {
		return profiles;
	}

	private static Map<Long, Comment> comment = new HashMap<Long, Comment>();

	public static Map<Long, Comment> getComment() {
		return comment;
	}
}
