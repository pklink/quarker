package net.einself.quarker.comment.resource.dto;

import net.einself.quarker.comment.validation.ThreadExists;

import javax.validation.constraints.NotEmpty;

public class CommentCreateRequest {

    @ThreadExists
    private Long threadId;

    @NotEmpty
    private String text;

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
}
