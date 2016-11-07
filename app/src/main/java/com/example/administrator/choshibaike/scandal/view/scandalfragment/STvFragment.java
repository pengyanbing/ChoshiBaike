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
import com.example.administrator.choshibaike.scandal.presenger.STvPresenger;
import com.example.administrator.choshibaike.scandal.view.adapter.FtvAdapter;
import com.example.administrator.choshibaike.scandal.view.adapter.StvLvAdapter;
import com.example.administrator.choshibaike.scandal.view.friendfragment.ITvView;

/**
 * Created by Administrator on 2016/11/1 0001.
 */
public class STvFragment extends BaseFragment implements ISTvView{
    public ListView stvflv;
    private Context context;
    public STvPresenger presenger;

    public STvFragment(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.stvfragment, container, false);
        stvflv = ((ListView) view.findViewById(R.id.stvlv));
        presenger = new STvPresenger(this, context);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenger.start();
    }

    @Override
    public void stvLvSetAdapter(StvLvAdapter adapter) {
        stvflv.setAdapter(adapter);
    }
}
