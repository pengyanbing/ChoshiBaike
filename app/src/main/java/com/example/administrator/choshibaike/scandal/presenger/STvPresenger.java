package com.example.administrator.choshibaike.scandal.presenger;

import android.content.Context;
import android.os.Handler;

import com.example.administrator.choshibaike.BasePresenter;
import com.example.administrator.choshibaike.scandal.model.IScardalData;
import com.example.administrator.choshibaike.scandal.model.IScardalDataImpl;
import com.example.administrator.choshibaike.scandal.model.OnDataLoadLisenter;
import com.example.administrator.choshibaike.scandal.model.bean.StvBean;
import com.example.administrator.choshibaike.scandal.view.adapter.StvLvAdapter;
import com.example.administrator.choshibaike.scandal.view.scandalfragment.ISTvView;
import com.example.administrator.choshibaike.scandal.view.scandalfragment.Ischtf;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/3 0003.
 */
public class STvPresenger implements BasePresenter {
    private IScardalData iScardalData;
    private ISTvView isTvView;
    private Context context;
    private Handler mHandler = new Handler();

    public STvPresenger(ISTvView isTvView, Context context) {
        this.isTvView = isTvView;
        this.context = context;
        iScardalData = new IScardalDataImpl();
    }

    @Override
    public void start() {
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
                        isTvView.stvLvSetAdapter(new StvLvAdapter(list1, context));
                    }
                });

            }

            @Override
            public void onFaild(String msg) {

            }
        }, "http://m2.qiushibaike.com/article/list/video?page=2&count=30&readarticles=[117855225,117857188,117859814,117857896,117857132,117857420,117861689]&rqcnt=119&r=53022f631478053093808");

    }
}
