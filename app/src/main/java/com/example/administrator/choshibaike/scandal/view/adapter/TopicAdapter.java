package com.example.administrator.choshibaike.scandal.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.choshibaike.R;
import com.example.administrator.choshibaike.scandal.model.bean.TopicBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/11/3 0003.
 */
public class TopicAdapter extends BaseAdapter {
    private List<TopicBean> list;
    private Context context;
    private LayoutInflater inflater;

    public TopicAdapter(List<TopicBean> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
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
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.topicitem, parent, false);
            holder = new MyViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.titl);
            holder.articy = (TextView) convertView.findViewById(R.id.articy);
            holder.count = (TextView) convertView.findViewById(R.id.count);
            holder.face = (ImageView) convertView.findViewById(R.id.iv);
            holder.ranking = (TextView) convertView.findViewById(R.id.ranking);
            convertView.setTag(holder);

        } else {
            holder = (MyViewHolder) convertView.getTag();
        }
        TopicBean bean = list.get(position);
        holder.ranking.setText(bean.getRank());
            holder.title.setText(bean.getContent());
        holder.articy.setText(bean.getAbstrac());
        holder.count.setText("动态" + bean.getArticle_count() + "  今日" + bean.getToday_article_count());
        Picasso.with(context).load(bean.getPic_url()).into(holder.face);
        return convertView;
    }

    class MyViewHolder {
        TextView title,count,articy, ranking;
        ImageView face;
    }
}
