package net.einself.quarker.comment.service;

import net.einself.quarker.comment.domain.Comment;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CommentService {

    @Inject
    CommentRepository commentRepository;

    @Transactional
    public Comment create(Comment comment) {
        comment.setId(null);
        commentRepository.persist(comment);
        return comment;
    }

    public List<Comment> findAll() {
        return commentRepository.listAll();
    }

}
