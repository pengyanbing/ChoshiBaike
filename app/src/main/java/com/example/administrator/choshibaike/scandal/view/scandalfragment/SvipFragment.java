package com.example.administrator.choshibaike.scandal.view.scandalfragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.choshibaike.BaseFragment;
import com.example.administrator.choshibaike.R;
import com.example.administrator.choshibaike.scandal.presenger.SvipPresenger;
import com.example.administrator.choshibaike.scandal.view.adapter.SivpLvAdapter;
import com.example.administrator.choshibaike.utils.Okhttpclient;

/**
 * Created by Administrator on 2016/11/1 0001.
 */
public class SvipFragment extends BaseFragment implements ISvipfView{
    public ListView lv;
    private Context context;
    public SvipPresenger presenger;
    public SwipeRefreshLayout refreshLayout;
    private int page = 1;
    public SvipFragment(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.svipfragment, container, false);
        lv = ((ListView) view.findViewById(R.id.sviplv));
        refreshLayout = ((SwipeRefreshLayout) view.findViewById(R.id.refresh));
        presenger = new SvipPresenger(this, context);
        presenger.start();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        refreshLayout.setColorSchemeColors(Color.RED,Color.GREEN,Color.BLUE);
        //下拉刷新监听
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                String svipurl = Okhttpclient.SVIPURL;
                Log.d("wode_sa", "onRefresh: '''''''''''''''''''");
                Okhttpclient.SVIPURL = String.format(svipurl, ++page);
                presenger.start();
            }
        });

    }

    @Override
    public void scrdaIvplvSetAdapter(SivpLvAdapter adapter) {
        lv.setAdapter(adapter);
        Log.d("wode_sa", "scrdaIvplvSetAdapter: 0000000000000000000"+Okhttpclient.SVIPURL);
        refreshLayout.setRefreshing(false);
    }
}
