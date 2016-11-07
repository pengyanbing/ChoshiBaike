package com.example.administrator.choshibaike.scandal.view.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.choshibaike.R;
import com.example.administrator.choshibaike.scandal.model.bean.StvBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/11/1 0001.
 */
public class SchtLvAdapter extends BaseAdapter {
    private List<StvBean> list;
    private Context context;
    private LayoutInflater inflater;

    public SchtLvAdapter(List<StvBean> list, Context context) {
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
        MyviewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.svipf_items, parent, false);
            holder = new MyviewHolder();
            holder.iv = (ImageView) convertView.findViewById(R.id.f0lviv);
            holder.iv0 = (ImageView) convertView.findViewById(R.id.iv1);
            holder.iv1 = (ImageView) convertView.findViewById(R.id.iv2);
            holder.iv2 = (ImageView) convertView.findViewById(R.id.iv3);
            holder.iv3 = (ImageView) convertView.findViewById(R.id.iv4);
            holder.img = (ImageView) convertView.findViewById(R.id.img);
            holder.hotiv = (ImageView) convertView.findViewById(R.id.f0lviv1);
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.content = (TextView) convertView.findViewById(R.id.content);
            holder.hot = (TextView) convertView.findViewById(R.id.hot);
            holder.count = (TextView) convertView.findViewById(R.id.count);
            convertView.setTag(holder);
        } else {
            holder = (MyviewHolder) convertView.getTag();
        }
        StvBean bean = list.get(position);

        String id = bean.getUser().getId();
        if (id.length() > 0) {
            String s = id.substring(0, id.length() - 4);
            Picasso.with(context).load("http://pic.qiushibaike.com/system/avtnew/" + s + "/"
                    + id + "/thumb/" + bean.getUser().getIcon()).into(holder.iv);

        } else {
            holder.iv.setImageResource(R.mipmap.ic_launcher);
        }
        holder.title.setText(bean.getUser().getLogin());
        String string = "好笑"+bean.getUp()+".评论"+bean.getComments_count()+".分享"+bean.getShare_count();
        holder.count.setText(string);
        if (bean.getImage()!=null && !bean.getImage().equals("null")&&bean.getImage().length() > 0) {
            holder.img.setVisibility(View.VISIBLE);
            String s1 = bean.getId().substring(0, bean.getId().length() - 4);
            Picasso.with(context).load("http://pic.qiushibaike.com/system/pictures/" + s1 + "/"
                    + bean.getId() +"/small/"+bean.getImage()).into(holder.img);
        }
        if (bean.getContent().length() > -1) {
            holder.content.setText(bean.getContent());
        }

        return convertView;
    }

    class MyviewHolder {
        ImageView iv,iv0,iv1,iv2, iv3,img,hotiv;
        TextView title,content, count,hot;
    }
}
