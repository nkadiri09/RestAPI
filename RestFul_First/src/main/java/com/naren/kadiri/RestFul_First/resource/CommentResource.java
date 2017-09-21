package com.naren.kadiri.RestFul_First.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.naren.kadiri.RestFul_First.model.Comment;
import com.naren.kadiri.RestFul_First.service.CommentService;

@Path("/")
public class CommentResource {

	private CommentService commentService = new CommentService();

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Comment> getAllComments(@PathParam("messageId") long messageId) {
		return (List<Comment>) commentService.getAllComments(messageId);
	}

	@GET
	@Path("/{commentId}")
	@Produces(MediaType.APPLICATION_XML)
	public Comment getComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
		return new Comment(1, "Narendra's Comment", "Narendra");
		// return commentService.getComment((int) messageId, (int) commentId);
	}

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Comment addComment(@PathParam("messageId") long messageId, Comment comment) {
		return commentService.addComment(messageId, comment);
	}

	@PUT
	@Path("/{commentId}")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Comment updateComment(@PathParam("messageId") long messageId, @PathParam("commentId") long id,
			Comment comment) {
		comment.setId((int) id);
		return commentService.updateComment(messageId, comment);
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	@Path("/{commentId}")
	public void deleteComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
		commentService.removeComment(messageId, (int) commentId);
	}

}
