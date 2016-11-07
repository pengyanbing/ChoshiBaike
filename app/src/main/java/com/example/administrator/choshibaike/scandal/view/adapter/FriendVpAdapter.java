package com.example.administrator.choshibaike.scandal.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/11/3 0003.
 */
public class FriendVpAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;
    private String[] titles;
    public FriendVpAdapter(FragmentManager fm, List<Fragment> list,String[] titles) {
        super(fm);
        this.titles = titles;
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
