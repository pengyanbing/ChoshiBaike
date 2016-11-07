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
import com.example.administrator.choshibaike.scandal.model.bean.StvBean;
import com.example.administrator.choshibaike.scandal.presenger.SctfPresenger;
import com.example.administrator.choshibaike.scandal.presenger.Shtfpresenter;
import com.example.administrator.choshibaike.scandal.view.adapter.SchtLvAdapter;
import com.example.administrator.choshibaike.scandal.view.adapter.SctLvAdapter;
import com.example.administrator.choshibaike.scandal.view.adapter.SivpLvAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/11/1 0001.
 */
public class SctFragment extends BaseFragment implements IctfView{
    private ListView lv;
    public View view;
    private Context context;
    public SctfPresenger shtfpresenter;

    public SctFragment(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.sctfragment, container, false);
        lv = ((ListView) view.findViewById(R.id.sviplv));
        shtfpresenter = new SctfPresenger(this, context);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        shtfpresenter.start();
    }


    @Override
    public void sctLvSetAdapter(SchtLvAdapter adapter) {
        lv.setAdapter(adapter);
    }
}
