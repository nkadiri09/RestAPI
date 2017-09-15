package com.naren.kadiri.RestFul_First.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.naren.kadiri.RestFul_First.dataSource.DataBaseClass;
import com.naren.kadiri.RestFul_First.model.Message;
import com.sun.xml.internal.bind.v2.Messages;

public class MessageService {

	private Map<Long, Message> messages = DataBaseClass.getMessage();

	public MessageService() {
		messages.put(1L, new Message(1, "Hellow world !", "Narendra"));
		messages.put(2L, new Message(2, "Hellow Jax-RS !", "Koushik"));

	}

	public List<Message> getAllMessages() {

		return new ArrayList<Message>(messages.values());
	}

	public Message getMessage(Long messageId) {
		return messages.get(messageId);
	}

	public Message addMessage(Message message) {

		message.setId(messages.size() + 1);
		messages.put((long) message.getId(), message);
		return message;
	}

	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		messages.put((long) message.getId(), message);
		return message;
	}

	public Message deleteMessage(Long id) {
		return messages.remove(id);
	}

}
