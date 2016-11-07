package com.example.administrator.choshibaike.scandal.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.choshibaike.scandal.model.bean.SetumBean;

import java.util.List;

/**
 * Created by Administrator on 2016/11/3 0003.
 */
public class Madapter extends BaseAdapter {
    private List<SetumBean> list;
    private Context context;

    public Madapter(List<SetumBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView view = new TextView(context);
        view.setText(list.get(position).getContent());
        return view;
    }
}
