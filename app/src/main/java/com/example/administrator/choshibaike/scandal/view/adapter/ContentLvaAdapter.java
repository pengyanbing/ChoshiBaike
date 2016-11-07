package com.example.administrator.choshibaike.scandal.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.choshibaike.R;
import com.example.administrator.choshibaike.scandal.model.bean.ContentBean;
import com.example.administrator.choshibaike.scandal.view.myview.MyImagView;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/11/5 0005.
 */
public class ContentLvaAdapter extends BaseAdapter {
    private List<ContentBean> list;
    private Context context;
    private LayoutInflater inflater;

    public ContentLvaAdapter(List<ContentBean> list, Context context) {
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
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.contentlv_items, parent, false);
            holder = new ViewHolder();
            holder.iv = (MyImagView) convertView.findViewById(R.id.face);
            holder.content = (TextView) convertView.findViewById(R.id.content);
            holder.count = (TextView) convertView.findViewById(R.id.count);
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.zcount = (TextView) convertView.findViewById(R.id.zcount);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        ContentBean bean = list.get(position);
        holder.content.setText(bean.getContent());

        holder.title.setText(bean.getLogin());
        holder.count.setText(bean.getFloor() + "楼");
        String id = bean.getId();
        String path = "";
        String path1="";
        if (id.length() > 0) {
            String s = id.substring(0, id.length() - 4);
            path = "http://pic.qiushibaike.com/system/avtnew/" + s + "/"
                    + id + "/thumb/" + bean.getIcon();
            Picasso.with(context).load(path).into(holder.iv);
        } else {
            holder.iv.setImageResource(R.mipmap.ic_launcher);
        }
        holder.zcount.setText(bean.getLike_count());
        return convertView;
    }

    class ViewHolder {
        MyImagView iv;
        TextView zcount,content, count,title;
    }
}
