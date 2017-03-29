package com.zzb.entity;


/**
 * Created by zzb on 2017/3/29.
 */

public class MenuEntity {
    private String title,context,url;

    public MenuEntity(String title, String context, String url) {
        this.title = title;
        this.context = context;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
