package com.example.administrator.choshibaike.scandal.view.friendfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.administrator.choshibaike.BaseFragment;
import com.example.administrator.choshibaike.R;
import com.example.administrator.choshibaike.scandal.presenger.friend.FseptumPresenger;
import com.example.administrator.choshibaike.scandal.presenger.friend.FtvPresenger;
import com.example.administrator.choshibaike.scandal.view.adapter.FtvAdapter;
import com.example.administrator.choshibaike.scandal.view.adapter.Madapter;
import com.example.administrator.choshibaike.scandal.view.adapter.SeptumAdapter;

/**
 * Created by Administrator on 2016/11/3 0003.
 */
public class TvFragment extends BaseFragment implements ITvView{
    public ListView lv;
    private Context context;
    public FtvPresenger presenger;
    public View view;

    public TvFragment(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.ftvfg, container, false);
        lv = ((ListView) view.findViewById(R.id.tvlv));
        presenger = new FtvPresenger(context, this);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenger.start();
    }

    @Override
    public void tcvlvSetAdapter(FtvAdapter adapter) {
        lv.setAdapter(adapter);
    }
}
