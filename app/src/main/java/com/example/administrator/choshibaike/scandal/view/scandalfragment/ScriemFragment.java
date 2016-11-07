package com.example.administrator.choshibaike.scandal.view.scandalfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.choshibaike.BaseFragment;
import com.example.administrator.choshibaike.R;
import com.example.administrator.choshibaike.scandal.presenger.SvipPresenger;
import com.example.administrator.choshibaike.scandal.view.adapter.SivpLvAdapter;

/**
 * Created by Administrator on 2016/11/1 0001.
 */
public class ScriemFragment extends BaseFragment implements ISvipfView{
    public ListView lv;
    private Context context;
    public SvipPresenger presenger;

    public ScriemFragment(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.svipfragment, container, false);
        lv = ((ListView) view.findViewById(R.id.sviplv));
        presenger = new SvipPresenger(this, context);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenger.start();
    }

    @Override
    public void scrdaIvplvSetAdapter(SivpLvAdapter adapter) {
        lv.setAdapter(adapter);
    }
}
