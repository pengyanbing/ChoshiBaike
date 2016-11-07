package com.example.administrator.choshibaike.scandal.presenger;

import android.content.Context;
import android.os.Handler;

import com.example.administrator.choshibaike.BasePresenter;
import com.example.administrator.choshibaike.scandal.model.IContentData;
import com.example.administrator.choshibaike.scandal.model.IContentImpl;
import com.example.administrator.choshibaike.scandal.model.OnDataLoadLisenter;
import com.example.administrator.choshibaike.scandal.model.bean.ContentBean;
import com.example.administrator.choshibaike.scandal.view.IContenView;
import com.example.administrator.choshibaike.scandal.view.adapter.ContentLvaAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/5 0005.
 */
public class ContentPresenger implements BasePresenter {
    private IContentData iContentData;
    private IContenView iContenView;
    private Context context;
    private Handler mHandler = new Handler();
    private String url;
    public ContentPresenger(IContenView iContenView, Context context,String url) {
        this.iContenView = iContenView;
        this.url = url;
        this.context = context;
        iContentData = new IContentImpl();
    }

    @Override
    public void start() {
iContentData.getContenData(new OnDataLoadLisenter() {
    @Override
    public void onSuccess(List<Object> list) {
        final List<ContentBean> list1 = new ArrayList<ContentBean>();
        for (int i = 0; i < list.size(); i++) {
            list1.add((ContentBean) list.get(i));
        }
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                iContenView.contentlvSetAdapter(new ContentLvaAdapter(list1, context));
            }
        });
    }

    @Override
    public void onFaild(String msg) {

    }
},url);
    }
}
