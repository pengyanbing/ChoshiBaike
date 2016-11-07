package com.example.administrator.choshibaike.scandal.presenger;

import android.content.Context;
import android.os.Handler;

import com.example.administrator.choshibaike.BasePresenter;
import com.example.administrator.choshibaike.scandal.model.IScardalData;
import com.example.administrator.choshibaike.scandal.model.IScardalDataImpl;
import com.example.administrator.choshibaike.scandal.model.OnDataLoadLisenter;
import com.example.administrator.choshibaike.scandal.model.bean.StvBean;
import com.example.administrator.choshibaike.scandal.view.adapter.SivpLvAdapter;
import com.example.administrator.choshibaike.scandal.view.scandalfragment.ISvipfView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/3 0003.
 */
public class SthroughPresenger implements BasePresenter {
    private IScardalData iScardalData;
    private ISvipfView iSvipfView;
    private Context context;
    private Handler mHandler = new Handler();

    public SthroughPresenger(ISvipfView iSvipfView, Context context) {
        this.iSvipfView = iSvipfView;
        this.context = context;
        iScardalData = new IScardalDataImpl();
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
                        iSvipfView.scrdaIvplvSetAdapter(new SivpLvAdapter(list1, context));
                    }
                });

            }

            @Override
            public void onFaild(String msg) {

            }
        }, "http://m2.qiushibaike.com/article/history?page=1&count=30&readarticles=[111535452,117862893]&rqcnt=65&r=53022f631477963117517");

    }
}
