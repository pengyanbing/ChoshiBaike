package com.example.administrator.choshibaike.scandal.view.friendfragment;

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
import com.example.administrator.choshibaike.scandal.presenger.friend.FtvPresenger;
import com.example.administrator.choshibaike.scandal.view.adapter.FriendVpAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/1 0001.
 */
public class FriendFragment extends BaseFragment implements IFriendFragment {
    public ViewPager FreandVp;
    private String[] titles = new String[]{"隔壁","已粉","视频","话题"};
    public TabLayout tabLayout;
    public List<Fragment> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.scandalfragment, container, false);
        FreandVp = ((ViewPager) view.findViewById(R.id.scandalVp));
        tabLayout = (TabLayout) view.findViewById(R.id.tableLayout);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        list = new ArrayList<>();
        list.add(new SeptumFragment(getActivity()));
        list.add(new FPowder());
        list.add(new TvFragment(getActivity()));
        list.add(new TopicF(getActivity()));
        FreandVp.setAdapter(new FriendVpAdapter(getFragmentManager(),list,titles));
        tabLayout.setupWithViewPager(FreandVp);
    }
}
