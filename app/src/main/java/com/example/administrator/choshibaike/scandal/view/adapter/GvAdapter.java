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
import android.widget.TextView;

import com.example.administrator.choshibaike.R;
import com.example.administrator.choshibaike.scandal.model.bean.SeedingBean;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2016/11/3 0003.
 */
public class GvAdapter extends BaseAdapter {
    private List<SeedingBean> list;
    private Context context;
    private LayoutInflater inflater;
    private MediaPlayer player;
    //记录当前正在播放的item的position
    private int currentPosition = -1;

    public GvAdapter(List<SeedingBean> list, Context context) {
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
        MyViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.allfg_item, parent, false);
            holder = new MyViewHolder();
            holder.logo = (TextView) convertView.findViewById(R.id.logo);
            holder.count = (TextView) convertView.findViewById(R.id.count);
            holder.iv = (ImageView) convertView.findViewById(R.id.iv);
            holder.surfaceView = (SurfaceView) convertView.findViewById(R.id.surface_view);
            convertView.setTag(holder);
        } else {
            holder = (MyViewHolder) convertView.getTag();
        }
        SeedingBean bean = list.get(position);
        holder.logo.setText(bean.getName());
        holder.count.setText(bean.getVisitors_count()+"人");
        Picasso.with(context).load(bean.getHeadurl()).into(holder.iv);

//
//        Object tag = holder.iv.getTag();
//        if (tag != null) {
//            Integer tag1 = (Integer) tag;
//            if (tag1 == currentPosition && tag1 != position) {
//                player.stop();
//                currentPosition = -1;
//            }
//        }
//
//        holder.iv.setTag(position);
//        if (currentPosition == position) {
//            holder.iv.setVisibility(View.INVISIBLE);
//            holder.surfaceView.setVisibility(View.VISIBLE);
//            player.reset();
//            player.setDisplay(holder.surfaceView.getHolder());
//            try {
//                String hign_url = bean.getUrl();
//                Log.d("wode_sa", "getView: " + hign_url);
//                if (hign_url != null) {
//                    player.setDataSource(hign_url);
//                    player.prepareAsync();
//                }
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }else{
//            holder.iv.setVisibility(View.VISIBLE);
//            holder.surfaceView.setVisibility(View.INVISIBLE);
//        }
//        holder.iv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (player.isPlaying()) {
//                    player.stop();
//                }
//                Integer tag = (Integer) v.getTag();
//                currentPosition = tag;
//                notifyDataSetChanged();
//            }
//        });
        return convertView;
    }

    class MyViewHolder {
        TextView logo, count;
        ImageView iv;
        SurfaceView surfaceView;
    }
}
