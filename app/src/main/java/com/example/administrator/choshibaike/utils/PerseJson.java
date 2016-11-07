package com.example.administrator.choshibaike.utils;

import android.util.Log;

import com.example.administrator.choshibaike.scandal.model.bean.ContentBean;
import com.example.administrator.choshibaike.scandal.model.bean.SeedingBean;
import com.example.administrator.choshibaike.scandal.model.bean.SetumBean;
import com.example.administrator.choshibaike.scandal.model.bean.StvBean;
import com.example.administrator.choshibaike.scandal.model.bean.TopicBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 *  private Purs pic_urls;
 private String distance;
 private String id;
 private String content;
 private String like_count;
 private String comments_count;
 * Created by Administrator on 2016/10/15 0015.
 */
public class PerseJson {

    public static List<Object> getJson(String json) {
        List<Object> list = new ArrayList<>();
        try {
            JSONArray items = new JSONObject(json).getJSONArray("items");
            for (int i = 0; i < items.length(); i++) {
                JSONObject data = items.getJSONObject(i);

                String image = null, high_url = null, loop = null, pic_url = null, tag = "";
                if (data.has("image")) {
                    image= data.getString("image");
                }
                if (data.has("high_url")) {
                    high_url = data.getString("high_url");
                }
                if (data.has("loop")) {
                    loop = data.getString("loop");
                }
                if (data.has("pic_url")) {
                    pic_url = data.getString("pic_url");
                }
                if (data.has("tag")) {
                    tag = data.getString("tag");
                }
                String format="", id="", content="", share_count="", comments_count="";
                if (data.has("format")) {
                    format = data.getString("format");
                }

                if (data.has("id")) {
                    id = data.getString("id");
                }

                if (data.has("content")) {
                    content = data.getString("content");
                }

                if (data.has("share_count")) {
                    share_count = data.getString("share_count");
                }

                if (data.has("comments_count")) {
                    comments_count = data.getString("comments_count");
                }

                String hot = "", login = "", id1 = "",icon="";
                if (data.has("hot")) {
                    hot = data.getString("type");
                }
                if (data.has("user")) {
                    JSONObject user = data.getJSONObject("user");
                    if (user.has("login")) {
                        login = user.getString("login");
                    }
                    if (user.has("id")) {
                        id1 = user.getString("id");
                    }
                    if (user.has("icon")) {
                        icon = user.getString("icon");
                    }
                }
                String up = "", down = "";
                if (data.has("votes")) {
                    JSONObject votes = data.getJSONObject("votes");
                    if (votes.has("down")) {
                        down = votes.getString("down");
                    }
                    if (votes.has("up")) {
                        up = votes.getString("up");
                    }
                }
                StvBean bean = new StvBean();
                bean.setImage(image);
                bean.setId(id);
                bean.setHign_url(high_url);
                bean.setFormat(format);
                bean.setTag(tag);
                bean.setUser(new StvBean.User(login, id1, icon));
                bean.setDown(down);
                bean.setUp(up);
                bean.setPic_url(pic_url);
                bean.setComments_count(comments_count);
                bean.setContent(content);
                bean.setShare_count(share_count);
                bean.setHot(hot);
                bean.setLoop(loop);
                list.add(bean);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.d("wode_sa", "getLieJson: "+list.size());
        return list;
    }

    public static List<Object> getSetumJson(String json) {
        List<Object> list = new ArrayList<>();
        try {
            JSONArray items = new JSONObject(json).getJSONArray("data");
            for (int i = 0; i < items.length(); i++) {
                JSONObject data = items.getJSONObject(i);
                String comments_count = "",like_count="",distance="",id="",content="";
                if (data.has("distance")) {
                    distance = data.getString("distance");
                }
                if (data.has("content")) {
                    content = data.getString("content");
                }

                if (data.has("id")) {
                    id = data.getString("id");
                }
                if (data.has("like_count")) {
                    like_count = data.getString("like_count");
                }
                if (data.has("comments_count")) {
                     comments_count = data.getString("comments_count");
                }

                String  login = "", id1 = "",icon="";
                if (data.has("user")) {
                    JSONObject user = data.getJSONObject("user");
                    if (user.has("login")) {
                        login = user.getString("login");
                    }
                    if (user.has("id")) {
                        id1 = user.getString("id");
                    }
                    if (user.has("icon")) {
                        icon = user.getString("icon");
                    }
                }
                ArrayList<String> list1 = new ArrayList<>();
                if (data.has("pic_urls")) {
                    JSONArray avatar_urls = data.getJSONArray("pic_urls");
                    if (avatar_urls.length() > 0) {
                        for (int j = 0; j < avatar_urls.length(); j++) {
                            JSONObject jsonObject = avatar_urls.getJSONObject(j);
                            if (jsonObject.has("pic_url")) {
                                list1.add(jsonObject.getString("pic_url"));
                            }
                        }
                    }

                }
                String vhigh_url="", vdpic_url="";
                if (data.has("video")) {
                    JSONObject video = data.getJSONObject("video");
                    if (video.has("high_url")) {
                        vhigh_url = video.getString("high_url");
                    }
                    if (video.has("pic_url")) {
                        vdpic_url = video.getString("pic_url");
                    }
                }

                SetumBean setumBean = new SetumBean();
                setumBean.setHigh_url(vhigh_url);
                setumBean.setPic_url(vdpic_url);
                setumBean.setLike_count(like_count);
                setumBean.setContent(content);
                setumBean.setComments_count(comments_count);
                setumBean.setDistance(distance);
                setumBean.setId(id);
                setumBean.setPic_urls(new SetumBean.Purs(list1));
                setumBean.setUser(new SetumBean.User(login,id1,icon));
                list.add(setumBean);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("wode_sa", "getSetumJson: " + list.size());
        return list;
    }

    public static List<Object> gettopicData(String json) {
        List<Object> list = new ArrayList<>();
        try {
            JSONArray data = new JSONObject(json).getJSONArray("data");
            for (int i = 0; i < data.length(); i++) {
                JSONObject da = data.getJSONObject(i);
                String rank = "", anAbstract = "", article_count = "", content = "", today_article_count = "", pic_url = "";
                if (da.has("rank")) {
                    rank = da.getString("rank");
                }
                if (da.has("abstract")) {
                    anAbstract = da.getString("abstract");
                }
                if (da.has("article_count")) {
                    article_count = da.getString("article_count");
                }
                if (da.has("content")) {
                    content = da.getString("content");
                }
                if (da.has("today_article_count")) {
                    today_article_count = da.getString("today_article_count");
                }
                if (da.has("avatar_urls")) {
                    JSONArray avatar_urls = da.getJSONArray("avatar_urls");
                    JSONObject jsonObject = avatar_urls.getJSONObject(0);
                    if (jsonObject.has("pic_url")) {
                        pic_url = jsonObject.getString("pic_url");
                    }
                }

                TopicBean topicBean = new TopicBean();
                topicBean.setAbstrac(anAbstract);
                topicBean.setArticle_count(article_count);
                topicBean.setContent(content);
                topicBean.setPic_url(pic_url);
                topicBean.setRank(rank);
                topicBean.setToday_article_count(today_article_count);
                list.add(topicBean);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("wode_sa", "gettopicData: " + list.size());
        return list;
    }

    public static List<Object> getseedingData(String json) {
        List<Object> list = new ArrayList<>();
        try {
            JSONArray lives = new JSONObject(json).getJSONArray("lives");
            for (int i = 0; i < lives.length(); i++) {
                JSONObject data = lives.getJSONObject(i);
                String name = data.getJSONObject("author").getString("name");

                String headurl = data.getJSONObject("author").getString("headurl");
                String visitors_count = data.getString("visitors_count");
                String url = data.getJSONObject("share").getString("url");
                SeedingBean bean = new SeedingBean();
                bean.setHeadurl(headurl);
                bean.setName(name);
                bean.setUrl(url);
                bean.setVisitors_count(visitors_count);
                list.add(bean);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("wode_sa", "getseedingData: " + list.size());
        return list;
    }
    public static List<Object> getcontentData(String json) {
        List<Object> list = new ArrayList<>();
        try {
            JSONArray items = new JSONObject(json).getJSONArray("items");
            for (int i = 0; i < items.length(); i++) {
                JSONObject data = items.getJSONObject(i);
                if (data.has("refer")) {
                    JSONObject refer = data.getJSONObject("refer");
                    String content = refer.getString("content");
                    String created_at = refer.getString("created_at");
                    String floor = refer.getString("floor");
                    String like_count = refer.getString("like_count");
                    JSONObject user = refer.getJSONObject("user");
                    String login = user.getString("login");
                    String icon=null,id=null;
                    if (user.has("icon")) {
                        icon = user.getString("icon");
                    }
                    if (user.has("id")) {
                        id = user.getString("id");
                    }
                    ContentBean bean = new ContentBean();
                    bean.setContent(content);
                    bean.setCreated_at(created_at);
                    bean.setFloor(floor);
                    bean.setLike_count(like_count);
                    bean.setLogin(login);
                    bean.setId(id);
                    bean.setIcon(icon);
                    list.add(bean);
                }
                String content = data.getString("content");
                String created_at = data.getString("created_at");
                String floor = data.getString("floor");
                String like_count = data.getString("like_count");
                JSONObject user = data.getJSONObject("user");
                String login = user.getString("login");
                String icon=null,id=null;
                if (user.has("icon")) {
                    icon = user.getString("icon");
                }
                if (user.has("id")) {
                    id = user.getString("id");
                }
                ContentBean bean = new ContentBean();
                bean.setContent(content);
                bean.setCreated_at(created_at);
                bean.setFloor(floor);
                bean.setLike_count(like_count);
                bean.setLogin(login);
                bean.setId(id);
                bean.setIcon(icon);
                list.add(bean);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("wode_sa", "getcontentData: "+list.size());
        return list;
    }

 }
