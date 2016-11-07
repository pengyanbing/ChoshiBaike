package com.example.administrator.choshibaike.scandal.presenger.friend;

import android.content.Context;
import android.os.Handler;

import com.example.administrator.choshibaike.BasePresenter;
import com.example.administrator.choshibaike.scandal.model.IseedingData;
import com.example.administrator.choshibaike.scandal.model.IseedingDataImpl;
import com.example.administrator.choshibaike.scandal.model.OnDataLoadLisenter;
import com.example.administrator.choshibaike.scandal.model.bean.SeedingBean;
import com.example.administrator.choshibaike.scandal.view.adapter.GvAdapter;
import com.example.administrator.choshibaike.scandal.view.seedingfragment.IAllsfgView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/3 0003.
 */
public class SeedingPresenger implements BasePresenter{
    private IseedingData iseedingData;
    private IAllsfgView iAllsfgView;
    private Context context;

    public SeedingPresenger(IAllsfgView iAllsfgView, Context context) {
        this.iAllsfgView = iAllsfgView;
        this.context = context;
        mHandler = new Handler();
        iseedingData = new IseedingDataImpl();
    }

    private Handler mHandler;

    @Override
    public void start() {
        iseedingData.getseedingData(new OnDataLoadLisenter() {
            @Override
            public void onSuccess(final List<Object> list) {
                final List<SeedingBean> list1 = new ArrayList<SeedingBean>();
                for (int i = 0; i < list.size(); i++) {
                    SeedingBean o = (SeedingBean) list.get(i);
                    list1.add(o);
                }
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iAllsfgView.gvSetAdapter(new GvAdapter(list1,context));
                    }
                });
            }

            @Override
            public void onFaild(String msg) {

            }
        },"http://live.qiushibaike.com/live/all/list?count=30&page=1&rqcnt=95&r=53022f631477963733132");
    }
}
