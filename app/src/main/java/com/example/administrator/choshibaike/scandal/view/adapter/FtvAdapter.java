package com.example.administrator.choshibaike.scandal.view.adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.choshibaike.R;
import com.example.administrator.choshibaike.scandal.model.bean.SetumBean;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2016/11/3 0003.
 */
public class FtvAdapter extends BaseAdapter {
    private List<SetumBean> list;
    private Context context;
    private LayoutInflater inflater;
    private MediaPlayer player;
    //记录当前正在播放的item的position
    private int currentPosition = -1;
    public FtvAdapter(List<SetumBean> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
        player = new MediaPlayer();
        player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });
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
            convertView = inflater.inflate(R.layout.ftvlv_item, parent, false);
            holder = new MyViewHolder();
            holder.content = (TextView) convertView.findViewById(R.id.content);
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.aera = (TextView) convertView.findViewById(R.id.aera);
            holder.count = (TextView) convertView.findViewById(R.id.count);
            holder.count1 = (TextView) convertView.findViewById(R.id.count1);
            holder.face = (ImageView) convertView.findViewById(R.id.f0lviv);
            holder.ll = (LinearLayout) convertView.findViewById(R.id.imgll);

            holder.imgv = (ImageView) convertView.findViewById(R.id.imgv);
            holder.surfaceView = (SurfaceView) convertView.findViewById(R.id.surface_view);
            holder.title1 = (TextView) convertView.findViewById(R.id.title1);
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
        String s = bean.getUser().getId().substring(0, bean.getUser().getId().length() - 4);
        Picasso.with(context).load("http://pic.qiushibaike.com/system/avtnew/" + s + "/"
                + bean.getUser().getId() +"/thumb/"+bean.getUser().getIcon()).into(holder.face);
        List<String> list = bean.getPic_urls().getList();
        String pic_url = bean.getPic_url();
        if (!pic_url.equals("")) {
            holder.ll.setVisibility(View.VISIBLE);
            Picasso.with(context).load(pic_url).into(holder.imgv);
        }
        Object tag = holder.imgv.getTag();
        if (tag != null) {
            Integer tag1 = (Integer) tag;
            if (tag1 == currentPosition && tag1 != position) {
                player.stop();
                currentPosition = -1;
            }
        }

        holder.imgv.setTag(position);
        if (currentPosition == position) {
            holder.imgv.setVisibility(View.INVISIBLE);
            holder.surfaceView.setVisibility(View.VISIBLE);
            player.reset();
            player.setDisplay(holder.surfaceView.getHolder());
            try {
                player.setDataSource(bean.getHigh_url());
                player.prepareAsync();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            holder.imgv.setVisibility(View.VISIBLE);
            holder.surfaceView.setVisibility(View.INVISIBLE);
        }
        holder.imgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player.isPlaying()) {
                    player.stop();
                }
                Integer tag = (Integer) v.getTag();
                currentPosition = tag;
                notifyDataSetChanged();
            }
        });
        return convertView;
    }

    class MyViewHolder {
        TextView content,title,aera,count,count1,title1;
        ImageView face,imgv;
        LinearLayout ll;
        SurfaceView surfaceView;
    }
}
