package net.einself.quarker.comment.service;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import net.einself.quarker.comment.domain.Comment;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
class CommentRepository implements PanacheRepository<Comment> {

}
