package com.naren.kadiri.RestFul_First.service;

import java.util.ArrayList;
import java.util.List;

import com.naren.kadiri.RestFul_First.model.Message;

public class MessageService {

	public List<Message> getMessages() {
		List<Message> messages = new ArrayList<Message>();
		Message msg1 = new Message(1, "Hellow world !", "Narendra");
		Message msg2 = new Message(2, "Hellow Jax-RS !", "Koushik");
		messages.add(msg1);
		messages.add(msg2);

		return messages;
	}

}
