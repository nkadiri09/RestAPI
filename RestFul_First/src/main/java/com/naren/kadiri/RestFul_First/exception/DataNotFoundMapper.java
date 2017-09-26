package com.naren.kadiri.RestFul_First.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.naren.kadiri.RestFul_First.model.ErrorMessage;

@Provider
public class DataNotFoundMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 404, "https://javabrains.io");
		return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
	}

}
