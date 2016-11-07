package com.example.administrator.choshibaike.scandal.presenger;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import com.example.administrator.choshibaike.scandal.model.IScardalData;
import com.example.administrator.choshibaike.scandal.model.IScardalDataImpl;
import com.example.administrator.choshibaike.scandal.model.OnDataLoadLisenter;
import com.example.administrator.choshibaike.scandal.model.bean.StvBean;
import com.example.administrator.choshibaike.scandal.view.adapter.SchtLvAdapter;
import com.example.administrator.choshibaike.scandal.view.scandalfragment.IctfView;
import com.example.administrator.choshibaike.scandal.view.scandalfragment.Ischtf;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/2 0002.
 */
public class SctfPresenger {
    private IScardalData iScardalData;
    private IctfView ictfView;
    private Context context;
    private Handler mHandler = new Handler();

    public SctfPresenger(IctfView ischtf, Context context) {
        this.ictfView = ischtf;
        this.context = context;
        iScardalData = new IScardalDataImpl();
    }
    public void start() {
        iScardalData.getStvfData(new OnDataLoadLisenter() {
            @Override
            public void onSuccess(List<Object> list) {
                final List<StvBean> list1 = new ArrayList<StvBean>();
                for (int i = 0; i < list.size(); i++) {
                    list1.add((StvBean) list.get(i));
                }
                Log.d("wode_sa", "onSuccess: +++++000000++++++"+list1.size());
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        ictfView.sctLvSetAdapter(new SchtLvAdapter(list1,context));
                    }
                });

            }

            @Override
            public void onFaild(String msg) {

            }
        }, "http://m2.qiushibaike.com/article/list/imgrank?page=1&count=30&readarticles=[117870287,117880389]&rqcnt=57&r=53022f631477962957666");

    }
}
