package com.example.administrator.choshibaike.scandal.view.seedingfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.choshibaike.BaseFragment;

/**
 * Created by Administrator on 2016/11/4 0004.
 */
public class SeePowder extends BaseFragment {
    private Context context;

    public SeePowder(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView view = new TextView(getActivity());
        view.setText("mifen");
        return view;
    }
}
