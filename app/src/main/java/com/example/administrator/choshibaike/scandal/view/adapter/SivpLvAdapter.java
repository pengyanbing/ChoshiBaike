package com.example.administrator.choshibaike.scandal.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.choshibaike.R;
import com.example.administrator.choshibaike.scandal.ContentActivity;
import com.example.administrator.choshibaike.scandal.model.bean.StvBean;
import com.example.administrator.choshibaike.scandal.view.myview.MyImagView;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/11/1 0001.
 */
public class SivpLvAdapter extends BaseAdapter {
    private List<StvBean> list;
    private Context context;
    private LayoutInflater inflater;

    public SivpLvAdapter(List<StvBean> list, Context context) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        final MyviewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.svipf_items, parent, false);
            holder = new MyviewHolder();
            holder.iv = (MyImagView) convertView.findViewById(R.id.f0lviv);
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
            holder.linearLayout = (LinearLayout) convertView.findViewById(R.id.contentll);
            convertView.setTag(holder);
        } else {
            holder = (MyviewHolder) convertView.getTag();
        }
        final StvBean bean = list.get(position);
        String id = bean.getUser().getId();
        String path = "";
        String path1="";
        if (id.length() > 0) {
            String s = id.substring(0, id.length() - 4);
             path = "http://pic.qiushibaike.com/system/avtnew/" + s + "/"
                    + id + "/thumb/" + bean.getUser().getIcon();
            Picasso.with(context).load(path).into(holder.iv);
        } else {
            holder.iv.setImageResource(R.mipmap.ic_launcher);
        }
        holder.title.setText(bean.getUser().getLogin());
        final String string = "好笑"+bean.getUp()+".评论"+bean.getComments_count()+".分享"+bean.getShare_count();
        holder.count.setText(string);
        if (bean.getImage()!=null && !bean.getImage().equals("null")&&bean.getImage().length() > 0) {
            holder.img.setVisibility(View.VISIBLE);
            String s1 = bean.getId().substring(0, bean.getId().length() - 4);
             path1 = "http://pic.qiushibaike.com/system/pictures/" + s1 + "/"
                    + bean.getId() + "/small/" + bean.getImage();
            Picasso.with(context).load(path1).into(holder.img);
        }
        if (bean.getContent().length() > -1) {
            holder.content.setText(bean.getContent());
        }

        final String finalPath = path;
        final String finalPath1 = path1;
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ContentActivity.class);
                intent.putExtra("path", finalPath);
                intent.putExtra("path1", finalPath1);
                intent.putExtra("content", bean.getContent());
                intent.putExtra("login", bean.getUser().getLogin());
                intent.putExtra("string", string);
                intent.putExtra("id", bean.getId());
                context.startActivity(intent);
            }
        });
        holder.iv0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String string = "好笑"+bean.getUp()+".评论"+bean.getComments_count()+".分享"+bean.getShare_count();
                holder.count.setText(string);
                holder.iv0.setImageResource(R.drawable.good_press);
                holder.iv1.setImageResource(R.drawable.nogood);
            }
        });
        holder.iv0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.iv0.setImageResource(R.drawable.good);
                holder.iv1.setImageResource(R.drawable.nogood_press);
            }
        });
        return convertView;
    }

    class MyviewHolder {
        ImageView iv0,iv1,iv2, iv3,img,hotiv;
        TextView title,content, count,hot;
        MyImagView iv;
        LinearLayout linearLayout;
    }
}
