package net.einself.quarker.comment.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Thread {

    public Long id;
    private String title;

}
