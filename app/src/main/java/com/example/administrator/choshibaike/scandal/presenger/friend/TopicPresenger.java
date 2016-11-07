package com.example.administrator.choshibaike.scandal.presenger.friend;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import com.example.administrator.choshibaike.BasePresenter;
import com.example.administrator.choshibaike.scandal.model.ITopicData;
import com.example.administrator.choshibaike.scandal.model.ITopicDataImpl;
import com.example.administrator.choshibaike.scandal.model.OnDataLoadLisenter;
import com.example.administrator.choshibaike.scandal.model.bean.TopicBean;
import com.example.administrator.choshibaike.scandal.view.adapter.TopicAdapter;
import com.example.administrator.choshibaike.scandal.view.friendfragment.TopicView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/3 0003.
 */
public class TopicPresenger implements BasePresenter{
    private ITopicData iTopicData;
    private TopicView topicView;
    private Context context;
    private Handler mHandler;

    public TopicPresenger(TopicView topicView, Context context) {
        this.topicView = topicView;
        this.context = context;
        iTopicData = new ITopicDataImpl();
        mHandler = new Handler();
    }

    @Override
    public void start() {
        Log.d("wode_sa", "start: laila");
        iTopicData.getTopicData(new OnDataLoadLisenter() {
            @Override
            public void onSuccess(List<Object> list) {
                final List<TopicBean> list1 = new ArrayList<TopicBean>();
                for (int i = 0; i < list.size(); i++) {
                   TopicBean   t= (TopicBean) list.get(i);
                    list1.add(t);
                }
                Log.d("wode_sa", "onSuccess: 999999999999999"+list.size());
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        topicView.lvsetAdapter(new TopicAdapter(list1, context));
                    }
                });
            }

            @Override
            public void onFaild(String msg) {

            }
        },"http://circle.qiushibaike.com/article/topic/top?page=1&count=20&rqcnt=82&r=53022f631477963582732");
    }
}
