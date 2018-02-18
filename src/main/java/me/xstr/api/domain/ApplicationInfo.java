package me.xstr.api.domain;

public class ApplicationInfo {

    private final long id;
    private final String content;

    public ApplicationInfo(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

}
