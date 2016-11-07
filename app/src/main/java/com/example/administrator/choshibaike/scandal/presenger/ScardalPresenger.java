package com.example.administrator.choshibaike.scandal.presenger;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import com.example.administrator.choshibaike.BasePresenter;
import com.example.administrator.choshibaike.scandal.model.IScardalData;
import com.example.administrator.choshibaike.scandal.model.IScardalDataImpl;
import com.example.administrator.choshibaike.scandal.model.OnDataLoadLisenter;
import com.example.administrator.choshibaike.scandal.model.bean.StvBean;
import com.example.administrator.choshibaike.scandal.view.adapter.SchtLvAdapter;
import com.example.administrator.choshibaike.scandal.view.adapter.SivpLvAdapter;
import com.example.administrator.choshibaike.scandal.view.adapter.StvLvAdapter;
import com.example.administrator.choshibaike.scandal.view.scandalfragment.IScardalView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/1 0001.
 */
public class ScardalPresenger implements BasePresenter{
    private IScardalData iScardalData;
    private IScardalView iScardalView;
    private Context context;
    private Handler mHandler = new Handler();

    public ScardalPresenger(IScardalView iScardalView,Context context) {
        this.iScardalView = iScardalView;
        iScardalData = new IScardalDataImpl();
        this.context = context;
    }

    @Override
    public void start() {
        iScardalData.getStvfData(new OnDataLoadLisenter() {
            @Override
            public void onSuccess(List<Object> list) {
                final List<StvBean> list1 = new ArrayList<StvBean>();
                for (int i = 0; i < list.size(); i++) {
                    list1.add((StvBean) list.get(i));
                }
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iScardalView.scrdaIvplvSetAdapter(new SivpLvAdapter(list1, context));
                    }
                });

            }

            @Override
            public void onFaild(String msg) {

            }
        }, "http://m2.qiushibaike.com/article/list/text?page=1&type=refresh&count=30&readarticles=[117874191,274921,117874361]&rqcnt=21&r=53022f631477961991399");

        iScardalData.getStvfData(new OnDataLoadLisenter() {
            @Override
            public void onSuccess(List<Object> list) {
                final List<StvBean> list1 = new ArrayList<>();
                for (int i = 0; i < list.size(); i++) {
                    list1.add((StvBean) list.get(i));
                }
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iScardalView.stvLvSetAdapter(new StvLvAdapter(list1, context));
                    }
                });

            }

            @Override
            public void onFaild(String msg) {

            }
        }, "http://m2.qiushibaike.com/article/list/video?page=2&count=30&readarticles=[117855225,117857188,117859814,117857896,117857132,117857420,117861689]&rqcnt=119&r=53022f631478053093808");


    }
}
