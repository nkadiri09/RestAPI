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

import com.naren.kadiri.RestFul_First.model.Message;
import com.naren.kadiri.RestFul_First.service.MessageService;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("messages")
public class MyResource {

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to the
	 * client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	MessageService msgService = new MessageService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getIt() {
		return msgService.getAllMessages();
	}

	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") Long messageId) {
		return msgService.getMessage(messageId);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message addMessages(Message message) {
		return msgService.addMessage(message);
	}

	@PUT
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") int id, Message message) {
		message.setId(id);
		return msgService.updateMessage(message);
	}

	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message deleteMessage(@PathParam("messageId") Long id) {
		return msgService.deleteMessage(id);
	}

}
