package com.example.administrator.choshibaike.scandal.model.bean;

/**
 * Created by Administrator on 2016/11/1 0001.
 */
public class StvBean {
    private String hign_url;
    private String format;
    private String tag;
    private String loop;
    private String pic_url;

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public String getHign_url() {
        return hign_url;
    }

    public void setHign_url(String hign_url) {
        this.hign_url = hign_url;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getLoop() {
        return loop;
    }

    public void setLoop(String loop) {
        this.loop = loop;
    }

    private String image;
    private String id;
    private String content;
    private String share_count;
    private String hot;
    private String comments_count;
    private User user;
    private String down;
    private String up;


    public StvBean() {
    }

    public String getHot() {
        return hot;
    }

    public void setHot(String hot) {
        this.hot = hot;
    }

    public StvBean(String image, String id, String content, String share_count, String hot, String comments_count, User user, String down, String up) {

        this.image = image;
        this.id = id;
        this.content = content;
        this.share_count = share_count;
        this.hot = hot;
        this.comments_count = comments_count;
        this.user = user;
        this.down = down;
        this.up = up;
    }

    public String getImage() {

        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public String getShare_count() {
        return share_count;
    }

    public void setShare_count(String share_count) {
        this.share_count = share_count;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getComments_count() {
        return comments_count;
    }

    public void setComments_count(String comments_count) {
        this.comments_count = comments_count;
    }

    public String getDown() {
        return down;
    }

    public void setDown(String down) {
        this.down = down;
    }

    public String getUp() {
        return up;
    }

    public void setUp(String up) {
        this.up = up;
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
