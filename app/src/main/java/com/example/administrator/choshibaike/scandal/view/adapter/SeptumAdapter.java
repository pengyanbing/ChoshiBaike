package com.example.administrator.choshibaike.scandal.view.adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.choshibaike.R;
import com.example.administrator.choshibaike.scandal.model.bean.SetumBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/11/3 0003.
 */
public class SeptumAdapter extends BaseAdapter {
    private List<SetumBean> list;
    private Context context;
    private LayoutInflater inflater;


    public SeptumAdapter(List<SetumBean> list, Context context) {
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
        MyViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.septumlv_item, parent, false);
            holder = new MyViewHolder();
            holder.content = (TextView) convertView.findViewById(R.id.content);
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.aera = (TextView) convertView.findViewById(R.id.aera);
            holder.count = (TextView) convertView.findViewById(R.id.count);
            holder.count1 = (TextView) convertView.findViewById(R.id.count1);
            holder.face = (ImageView) convertView.findViewById(R.id.f0lviv);
            holder.img1 = (ImageView) convertView.findViewById(R.id.simg1);
            holder.img2 = (ImageView) convertView.findViewById(R.id.simg2);
            holder.img3 = (ImageView) convertView.findViewById(R.id.simg3);
            holder.ll = (LinearLayout) convertView.findViewById(R.id.imgll);
            convertView.setTag(holder);
        } else {
            holder = (MyViewHolder) convertView.getTag();
        }
        SetumBean bean = list.get(position);
        holder.content.setText(bean.getContent());
        holder.title.setText(bean.getUser().getLogin());
        holder.aera.setText(bean.getDistance());
        holder.count.setText(bean.getLike_count());
        holder.count1.setText(bean.getComments_count());
        String id = bean.getUser().getId();
        if (id.length() > 4) {
            String s = id.substring(0, id.length() - 4);
            Picasso.with(context).load("http://pic.qiushibaike.com/system/avtnew/" + s + "/"
                    + id + "/thumb/" + bean.getUser().getIcon()).into(holder.face);
        } else {
            holder.face.setImageResource(R.mipmap.ic_launcher);
        }
        List<String> list = bean.getPic_urls().getList();

        int size = list.size();
        if (size==1) {
            holder.ll.setVisibility(View.VISIBLE);
            Picasso.with(context).load(list.get(0)).into(holder.img1);
        } else if (size == 2) {
            holder.ll.setVisibility(View.VISIBLE);
            Picasso.with(context).load(list.get(0)).into(holder.img1);
            Picasso.with(context).load(list.get(1)).into(holder.img2);
        } else if (size>2) {
            holder.ll.setVisibility(View.VISIBLE);
            Picasso.with(context).load(list.get(0)).into(holder.img1);
            Picasso.with(context).load(list.get(1)).into(holder.img2);
            Picasso.with(context).load(list.get(2)).into(holder.img3);
        }
        return convertView;
    }

    class MyViewHolder {
        TextView content,title,aera,count,count1;
        ImageView face,img1,img2,img3;
        LinearLayout ll;
    }
}
