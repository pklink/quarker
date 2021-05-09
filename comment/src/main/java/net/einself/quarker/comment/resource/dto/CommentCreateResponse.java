package net.einself.quarker.comment.resource.dto;

public class CommentCreateResponse {

    private final Long id;
    private final String text;

    public CommentCreateResponse(Long id, String text) {
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
