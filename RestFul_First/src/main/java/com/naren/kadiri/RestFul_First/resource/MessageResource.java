package com.naren.kadiri.RestFul_First.resource;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.naren.kadiri.RestFul_First.model.Message;
import com.naren.kadiri.RestFul_First.service.MessageService;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to the
	 * client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	MessageService messageService = new MessageService();

	@GET
	public List<Message> getMessages(@QueryParam("year") int year, @QueryParam("start") int start,
			@QueryParam("size") int size) {
		if (year > 0) {
			return messageService.getAllMessagesForYear(year);
		}
		if (start >= 0 && size > 0) {
			return messageService.getAllMessagesPaginated(start, size);
		}
		return messageService.getAllMessages();
	}

	/*
	 * @GET public List<Message> getMessages1(@BeanParam MessageFilter
	 * messageFilter) { if (messageFilter.getYear() > 0) { return
	 * messageService.getAllMessagesForYear(messageFilter.getYear()); } if
	 * (messageFilter.getStart() >= 0 && messageFilter.getSize() > 0) { return
	 * messageService.getAllMessagesPaginated(messageFilter.getStart(),
	 * messageFilter.getSize()); } return messageService.getAllMessages(); }
	 */

	@POST
	public Response addMessages(Message message, @Context UriInfo uriInfo) {
		Message newMessage = messageService.addMessage(message);
		String messageId = String.valueOf(newMessage.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(messageId).build();
		return Response.created(uri).entity(newMessage).build();
	}

	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") int id, Message message) {
		message.setId(id);
		return messageService.updateMessage(message);
	}

	@DELETE
	@Path("/{messageId}")
	public Message deleteMessage(@PathParam("messageId") Long id) {
		return messageService.deleteMessage(id);
	}

	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}

	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") Long messageId, @Context UriInfo uriInfo) {
		Message message = messageService.getMessage(messageId);
		message.addLink(getUriForSelf(uriInfo, message), "self");
		message.addLink(getUriForProfiles(uriInfo, message), "profile");
		message.addLink(getUriInfoForComments(uriInfo, message), "Comments)");
		return messageService.getMessage(messageId);
	}

	private String getUriInfoForComments(UriInfo uriInfo, Message message) {
		String url = uriInfo.getBaseUriBuilder().path(MessageResource.class)
				.path(MessageResource.class, "getCommentResource").path(CommentResource.class)
				.resolveTemplate("messageId", message.getId()).path(Long.toString(message.getId())).build().toString();
		return url;
	}

	private String getUriForProfiles(UriInfo uriInfo, Message message) {
		String url = uriInfo.getBaseUriBuilder().path(ProfileResource.class).path(message.getAuthor()).build()
				.toString();
		return url;
	}

	public String getUriForSelf(UriInfo uriInfo, Message message) {
		String url = uriInfo.getBaseUriBuilder().path(MessageResource.class).path(Long.toString(message.getId()))
				.build().toString();
		return url;
	}

}
