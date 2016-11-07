package com.example.administrator.choshibaike.scandal.model.bean;

/**
 * Created by Administrator on 2016/11/3 0003.
 */
public class TopicBean {
    private String pic_url;
    private String content;
    private String rank;
    private String abstrac;
    private String article_count;
    private String today_article_count;

    public String getPic_url() {
        return pic_url;
    }

    public TopicBean() {
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getAbstrac() {
        return abstrac;
    }

    public void setAbstrac(String abstrac) {
        this.abstrac = abstrac;
    }

    public String getArticle_count() {
        return article_count;
    }

    public void setArticle_count(String article_count) {
        this.article_count = article_count;
    }

    public String getToday_article_count() {
        return today_article_count;
    }

    public void setToday_article_count(String today_article_count) {
        this.today_article_count = today_article_count;
    }

    public TopicBean(String pic_url, String content, String rank, String abstrac, String article_count, String today_article_count) {

        this.pic_url = pic_url;
        this.content = content;
        this.rank = rank;
        this.abstrac = abstrac;
        this.article_count = article_count;
        this.today_article_count = today_article_count;
    }
}
