package jaxrs.learn.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class RecordNotFoundExceptionMapper implements ExceptionMapper<RecordNotFoundException> {

	@Override
	public Response toResponse(RecordNotFoundException exception) {
		
		return Response.status(Status.NOT_FOUND).entity("Record Not Found :: " + exception.getMessage()).build();
	}
}
