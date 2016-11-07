package com.example.administrator.choshibaike.scandal.model.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/11/3 0003.
 */
public class SetumBean {
    private Purs pic_urls;
    private String distance;
    private String id;
    private String content;
    private String like_count;
    private String comments_count;
    private User user;
    private String high_url;
    private String pic_url;

    public String getHigh_url() {
        return high_url;
    }

    public void setHigh_url(String high_url) {
        this.high_url = high_url;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public SetumBean() {
    }

    public Purs getPic_urls() {

        return pic_urls;
    }

    public void setPic_urls(Purs pic_urls) {
        this.pic_urls = pic_urls;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLike_count() {
        return like_count;
    }

    public void setLike_count(String like_count) {
        this.like_count = like_count;
    }

    public String getComments_count() {
        return comments_count;
    }

    public void setComments_count(String comments_count) {
        this.comments_count = comments_count;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SetumBean(Purs pic_urls, String distance, String id, String content, String like_count, String comments_count, User user) {

        this.pic_urls = pic_urls;
        this.distance = distance;
        this.id = id;
        this.content = content;
        this.like_count = like_count;
        this.comments_count = comments_count;
        this.user = user;
    }

    public static class Purs {
        private List<String> list;

        public Purs() {
        }

        public Purs(List<String> list) {

            this.list = list;
        }

        public List<String> getList() {
            return list;
        }

        public void setList(List<String> list) {
            this.list = list;
        }
    }
    public static class User {
        private String login;
        private String id;
        private String icon;

        public User(String login, String id, String icon) {
            this.login = login;
            this.id = id;
            this.icon = icon;
        }

        public String getIcon() {

            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public User() {
        }

        public String getLogin() {

            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public User(String login, String id) {
            this.login = login;
            this.id = id;
        }
    }
}
