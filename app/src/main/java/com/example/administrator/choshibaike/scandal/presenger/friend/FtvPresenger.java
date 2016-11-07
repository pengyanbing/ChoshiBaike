package com.example.administrator.choshibaike.scandal.presenger.friend;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import com.example.administrator.choshibaike.BasePresenter;
import com.example.administrator.choshibaike.scandal.model.ISetumData;
import com.example.administrator.choshibaike.scandal.model.ISetumDataIpml;
import com.example.administrator.choshibaike.scandal.model.OnDataLoadLisenter;
import com.example.administrator.choshibaike.scandal.model.bean.SetumBean;
import com.example.administrator.choshibaike.scandal.view.adapter.FtvAdapter;
import com.example.administrator.choshibaike.scandal.view.adapter.Madapter;
import com.example.administrator.choshibaike.scandal.view.friendfragment.ITvView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/3 0003.
 */
public class FtvPresenger implements BasePresenter{
    private ISetumData iSetumData;
    private ITvView iTvView;
    private  Context context;
    private Handler mHandler =null;

    public FtvPresenger(Context context, ITvView iTvView) {
        this.context = context;
        this.iTvView = iTvView;
        iSetumData = new ISetumDataIpml();
        mHandler = new Handler();
    }

    @Override
    public void start() {
        iSetumData.getSemtuData(new OnDataLoadLisenter() {
            @Override
            public void onSuccess(final List<Object> list) {
                final List<SetumBean> list1 = new ArrayList<SetumBean>();
                for (int i = 0; i < list.size(); i++) {
                    SetumBean o = (SetumBean) list.get(i);
                    list1.add(o);
                }
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                      iTvView.tcvlvSetAdapter(new FtvAdapter(list1,context));
                    }
                });
            }

            @Override
            public void onFaild(String msg) {

            }
        },"http://circle.qiushibaike.com/article/video/list?page=1&latitude=23.176319&longitude=113.340737&rqcnt=81&r=53022f631477963513475");
    }
}
