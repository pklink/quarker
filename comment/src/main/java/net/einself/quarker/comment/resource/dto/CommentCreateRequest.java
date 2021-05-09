package net.einself.quarker.comment.resource.dto;

public class CommentCreateRequest {

    private Long threadId;
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
