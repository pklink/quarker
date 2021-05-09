package net.einself.quarker.comment.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Long threadId;

    @Column(nullable = false)
    public String text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getThreadId() {
        return threadId;
    }

    public void setThreadId(Long threadId) {
        this.threadId = threadId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final var comment = (Comment) o;
        return Objects.equals(id, comment.id) && Objects.equals(threadId, comment.threadId) && Objects.equals(text, comment.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, threadId, text);
    }

    public static class Builder {

        private final Comment comment;

        public Builder() {
            this.comment = new Comment();
        }

        public Builder id(Long id) {
            comment.setId(id);
            return this;
        }

        public Builder threadId(Long threadId) {
            comment.setThreadId(threadId);
            return this;
        }

        public Builder text(String text) {
            comment.setText(text);
            return this;
        }

        public Comment build() {
            return comment;
        }

    }

}
