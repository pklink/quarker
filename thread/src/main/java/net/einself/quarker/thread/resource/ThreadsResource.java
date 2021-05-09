package net.einself.quarker.thread.resource;

import net.einself.quarker.thread.domain.Thread;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/threads")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ThreadsResource {

    @Inject
    EntityManager entityManager;

    @POST
    @Transactional
    public Thread create(Thread thread) {
        entityManager.persist(thread);
        return thread;
    }

    @GET
    @Path("/{id}")
    public Thread get(@PathParam Long id) {
        return entityManager.find(Thread.class, id);
    }

    @GET
    public List<Thread> list() {
        final var criteriaBuilder = entityManager.getCriteriaBuilder();
        final var query = criteriaBuilder.createQuery(Thread.class);
        final var all = query.select(query.from(Thread.class));
        return entityManager.createQuery(all).getResultList();
    }

}
