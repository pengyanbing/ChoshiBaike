package com.example.administrator.choshibaike.scandal.presenger.friend;

import android.content.Context;
import android.os.Handler;

import com.example.administrator.choshibaike.BaseFragment;
import com.example.administrator.choshibaike.BasePresenter;
import com.example.administrator.choshibaike.scandal.model.ISetumData;
import com.example.administrator.choshibaike.scandal.model.ISetumDataIpml;
import com.example.administrator.choshibaike.scandal.model.OnDataLoadLisenter;
import com.example.administrator.choshibaike.scandal.model.bean.SetumBean;
import com.example.administrator.choshibaike.scandal.view.adapter.SeptumAdapter;
import com.example.administrator.choshibaike.scandal.view.friendfragment.ISetumView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/3 0003.
 */
public class FseptumPresenger implements BasePresenter{
    private ISetumData iSetumData;
    private  ISetumView iSetumView;
    private  Context context;
    private Handler mHandler = new Handler();

    public FseptumPresenger(Context context, ISetumView iSetumView) {
        this.context = context;
        this.iSetumView = iSetumView;
        iSetumData = new ISetumDataIpml();

    }

    @Override
    public void start() {
        iSetumData.getSemtuData(new OnDataLoadLisenter() {
            @Override
            public void onSuccess(List<Object> list) {
                final List<SetumBean> list1 = new ArrayList<SetumBean>();
                for (int i = 0; i < list.size(); i++) {
                    SetumBean o = (SetumBean) list.get(i);
                    list1.add(o);
                }
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iSetumView.lvSetAdapter(new SeptumAdapter(list1,context));
                    }
                });
            }

            @Override
            public void onFaild(String msg) {

            }
        },"http://circle.qiushibaike.com/article/nearby/list?page=1&latitude=23.176344&longitude=113.340738&count=30&rqcnt=77&r=53022f631477963411141");
    }
}
