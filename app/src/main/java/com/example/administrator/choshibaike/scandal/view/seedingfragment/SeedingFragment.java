package com.example.administrator.choshibaike.scandal.view.seedingfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.choshibaike.BaseFragment;
import com.example.administrator.choshibaike.R;
import com.example.administrator.choshibaike.scandal.view.adapter.FriendVpAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/3 0003.
 */
public class SeedingFragment extends BaseFragment {
    private String[] titles = new String[]{"全部","已粉"};
    public TabLayout ta;
    public ViewPager vp;
    public List<Fragment> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.seedingfg, container, false);
        vp = (ViewPager) view.findViewById(R.id.seedingVp);
        ta = (TabLayout) view.findViewById(R.id.tableLayout);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        list = new ArrayList<>();
        list.add(new IAllsfg(getActivity()));
        list.add(new SeePowder(getActivity()));
        vp.setAdapter(new FriendVpAdapter(getFragmentManager(),list,titles));
        ta.setupWithViewPager(vp);
    }
}
