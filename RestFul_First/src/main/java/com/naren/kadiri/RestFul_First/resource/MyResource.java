package com.naren.kadiri.RestFul_First.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.naren.kadiri.RestFul_First.model.Message;
import com.naren.kadiri.RestFul_First.service.MessageService;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to
	 * the client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	MessageService msgService = new MessageService();

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getIt() {
		return msgService.getMessages();
	}
}
