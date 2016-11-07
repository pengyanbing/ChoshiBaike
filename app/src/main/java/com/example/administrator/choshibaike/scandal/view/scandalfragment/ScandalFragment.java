package com.example.administrator.choshibaike.scandal.view.scandalfragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.choshibaike.BaseFragment;
import com.example.administrator.choshibaike.R;
import com.example.administrator.choshibaike.scandal.AddActivity;
import com.example.administrator.choshibaike.scandal.model.bean.StvBean;
import com.example.administrator.choshibaike.scandal.presenger.ScardalPresenger;
import com.example.administrator.choshibaike.scandal.view.MainActivity;
import com.example.administrator.choshibaike.scandal.view.adapter.ScardalVpAdapter;
import com.example.administrator.choshibaike.scandal.view.adapter.SchtLvAdapter;
import com.example.administrator.choshibaike.scandal.view.adapter.SivpLvAdapter;
import com.example.administrator.choshibaike.scandal.view.adapter.StvLvAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/1 0001.
 */
public class ScandalFragment extends BaseFragment {
    private ViewPager scardalVp;
    private ScardalPresenger scardalPresenger;
    public SvipFragment svipFragment;
    public STvFragment stvFragment;
    public SchtFragment schtf;
    public SctFragment sctf;
    public List<Fragment> list;
    public TabLayout tabLayout;
    private String[] titles = new String[]{"专享","视频","纯文","纯图","精华","穿越"};
    public ImageView add;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.scandalfragment, container, false);
        tabLayout = ((TabLayout) view.findViewById(R.id.tableLayout));
        scardalVp = ((ViewPager) view.findViewById(R.id.scandalVp));
        add = ((ImageView) view.findViewById(R.id.add));
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( getActivity(), AddActivity.class );
                startActivity(intent);
            }
        });
        initSfragment();
        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        scardalVp.setAdapter(new ScardalVpAdapter(getChildFragmentManager(), list,titles));
        tabLayout.setupWithViewPager(scardalVp);
    }

    public void initSfragment() {
        list = new ArrayList<>();
        svipFragment = new SvipFragment(getActivity());
        list.add(svipFragment);
        stvFragment = new STvFragment(getActivity());
        list.add(stvFragment);
        schtf = new SchtFragment(getActivity());
        list.add(schtf);
        sctf = new SctFragment(getActivity());
        list.add(sctf);
        list.add(new ScriemFragment(getActivity()));
        list.add(new SthroughFragment(getActivity()));
    }
}
