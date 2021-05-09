package net.einself.quarker.comment.resource.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.einself.quarker.comment.domain.Comment;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class CommentListResponse {

    @JsonProperty("data")
    private final List<CommentEntity> entities;

    CommentListResponse(List<CommentEntity> entities) {
        this.entities = entities;
    }

    public List<CommentEntity> getEntities() {
        return entities;
    }

    public static CommentListResponse of(List<Comment> comments) {
        final var entities = comments.stream()
                .map(comment -> new CommentEntity(comment.getId(), comment.getText()))
                .collect(toList());
        return new CommentListResponse(entities);
    }

    static class CommentEntity {

        private final Long id;
        private final String text;

        public CommentEntity(Long id, String text) {
            this.id = id;
            this.text = text;
        }

        public Long getId() {
            return id;
        }

        public String getText() {
            return text;
        }
    }

}
