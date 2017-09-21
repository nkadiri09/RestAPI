package com.naren.kadiri.RestFul_First.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.naren.kadiri.RestFul_First.dataSource.DataBase;
import com.naren.kadiri.RestFul_First.model.Comment;
import com.naren.kadiri.RestFul_First.model.Message;

public class CommentService {

	private Map<Long, Message> messages = DataBase.getMessage();

	/*
	 * private Map<Long, Comment> comments1 = DataBase.getComment();
	 * 
	 * public CommentService() { comments1.put(1L, new Comment(1,
	 * "Narendra's Comment", "Narendra")); comments1.put(2L, new Comment(2,
	 * "RECommented By Naren", "Narendra2")); }
	 */

	public List<Comment> getAllComments(long messageId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<Comment>(comments.values());
	}

	public Comment getComment(int messageId, int commentId) {

		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.get(commentId);
		// return new Comment(1, "Narendra's Comment", "Narendra");
	}

	public Comment addComment(Long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size() + 1);
		comments.put((long) comment.getId(), comment);
		return comment;
	}

	public Comment updateComment(Long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if (comment.getId() <= 0) {
			return null;
		}
		comments.put((long) comment.getId(), comment);
		return comment;
	}

	public Comment removeComment(Long messageId, int commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.remove(commentId);
	}
}
