package com.example.administrator.choshibaike.scandal.model.bean;

/**
 * Created by Administrator on 2016/11/3 0003.
 */
public class SeedingBean {
    private String headurl;
    private String name;
    private String url;
    private String visitors_count;

    public SeedingBean() {
    }

    public String getHeadurl() {
        return headurl;

    }

    public void setHeadurl(String headurl) {
        this.headurl = headurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVisitors_count() {
        return visitors_count;
    }

    public void setVisitors_count(String visitors_count) {
        this.visitors_count = visitors_count;
    }

    public SeedingBean(String headurl, String name, String url, String visitors_count) {

        this.headurl = headurl;
        this.name = name;
        this.url = url;
        this.visitors_count = visitors_count;
    }
}
