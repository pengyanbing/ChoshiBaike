package com.example.administrator.choshibaike.scandal.view.seedingfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.administrator.choshibaike.BaseFragment;
import com.example.administrator.choshibaike.R;
import com.example.administrator.choshibaike.scandal.presenger.friend.SeedingPresenger;
import com.example.administrator.choshibaike.scandal.view.adapter.GvAdapter;

/**
 * Created by Administrator on 2016/11/3 0003.
 */
public class IAllsfg extends BaseFragment implements IAllsfgView {
    public GridView gv;
    private Context context;
    public SeedingPresenger presenger;

    public IAllsfg(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.allfg, container, false);
        gv = ((GridView) view.findViewById(R.id.gv));
        presenger = new SeedingPresenger(this, context);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenger.start();
    }

    @Override
    public void gvSetAdapter(GvAdapter adapter) {
        gv.setAdapter(adapter);
    }
}
