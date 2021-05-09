package net.einself.quarker.comment.resource;

import net.einself.quarker.comment.client.ThreadClient;
import net.einself.quarker.comment.domain.Comment;
import net.einself.quarker.comment.resource.dto.CommentCreateRequest;
import net.einself.quarker.comment.resource.dto.CommentCreateResponse;
import net.einself.quarker.comment.resource.dto.CommentListResponse;
import net.einself.quarker.comment.service.CommentService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Path("/comments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {

    @Inject
    CommentService commentService;

    @Inject
    @RestClient
    ThreadClient threadClient;

    @POST
    public CommentCreateResponse create(CommentCreateRequest request) {
        final var thread = Optional.ofNullable(threadClient.getById(request.getThreadId()))
                .orElseThrow(BadRequestException::new);

        final var comment = new Comment();
        comment.setThreadId(thread.id);
        comment.setText(request.getText());
        commentService.create(comment);

        return new CommentCreateResponse(comment.getId(), comment.getText());
    }

    @GET
    public CommentListResponse list() {
        final var comments = commentService.findAll();
        return CommentListResponse.of(comments);
    }

}
