package net.einself.quarker.comment.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/threads")
@RegisterRestClient
public interface ThreadClient {

    @GET
    @Path("/{id}")
    Thread getById(@PathParam Long id);

}
