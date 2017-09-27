package com.naren.kadiri.RestFul_First.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.naren.kadiri.RestFul_First.dataSource.DataBase;
import com.naren.kadiri.RestFul_First.exception.DataNotFoundException;
import com.naren.kadiri.RestFul_First.model.Comment;
import com.naren.kadiri.RestFul_First.model.Message;

public class MessageService {

	private Map<Long, Message> messages = DataBase.getMessage();

	/*
	 * public MessageService() { messages.put(1L, new Message(1, "Hellow world !",
	 * "Narendra")); messages.put(2L, new Message(2, "Hellow Jax-RS !", "Koushik"));
	 * 
	 * }
	 */

	private Map<Long, Comment> comments = DataBase.getComment();

	public MessageService() {

		comments.put(1L, new Comment(1, "Narendra Kadiri's Comment", "Narendra"));
		comments.put(2L, new Comment(2, "Narendra's kkkkakskskkComment", "Narendra2"));

		messages.put(1L, new Message(1, "Narendas Message", "Narendra", comments));
		messages.put(2L, new Message(2, "Narendas ffffffMessage", "Narafafafaaendra", comments));

		// messages.put(1L, new Message(1, "Hellow world !", "Narendra2"));
		// messages.put(2L, new Message(2, "Hellow Jax-RS !", "Koushik2"));
	}

	public List<Message> getAllMessages() {

		return new ArrayList<Message>(messages.values());
	}

	public Message getMessage(Long messageId) {
		Message message = messages.get(messageId);
		if (message == null) {
			// throw new DataNotFoundException("Message with Id: " + messageId + " Not
			// fount");
		}
		return message;
	}

	public List<Message> getAllMessagesForYear(int year) {
		List<Message> messagesForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for (Message message : messages.values()) {
			cal.setTime(message.getCreated());
			if (cal.get(Calendar.YEAR) == year) {
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}

	public List<Message> getAllMessagesPaginated(int start, int size) {
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		if (start + size > list.size())
			return new ArrayList<Message>();
		return list.subList(start, start + size);
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
