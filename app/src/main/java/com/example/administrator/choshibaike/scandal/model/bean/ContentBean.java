package com.example.administrator.choshibaike.scandal.model.bean;

/**
 * Created by Administrator on 2016/11/5 0005.
 */
public class ContentBean {
    private String content;
    private String id;
    private String icon;
    private String login;
    private String like_count;
    private String floor;
    private String created_at;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLike_count() {
        return like_count;
    }

    public void setLike_count(String like_count) {
        this.like_count = like_count;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public ContentBean() {

    }

    public ContentBean(String content, String id, String icon, String login, String like_count, String floor, String created_at) {

        this.content = content;
        this.id = id;
        this.icon = icon;
        this.login = login;
        this.like_count = like_count;
        this.floor = floor;
        this.created_at = created_at;
    }
}
