package net.einself.quarker.comment.resource;

import net.einself.quarker.comment.domain.Comment;
import net.einself.quarker.comment.resource.dto.CommentCreateRequest;
import net.einself.quarker.comment.resource.dto.CommentCreateResponse;
import net.einself.quarker.comment.resource.dto.CommentListResponse;
import net.einself.quarker.comment.service.CommentService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/comments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {

    @Inject
    CommentService commentService;

    @POST
    public CommentCreateResponse create(@Valid CommentCreateRequest request) {
        final var comment = new Comment();
        comment.setThreadId(request.getThreadId());
        comment.setText(request.getText());
        commentService.create(comment);

        return new CommentCreateResponse(comment.getId(), comment.getText());
    }

    @GET
    public CommentListResponse list(@NotNull @QueryParam("threadId") Long threadId) {
        final var comments = commentService.findAllByThreadId(threadId);
        return CommentListResponse.of(comments);
    }

}
