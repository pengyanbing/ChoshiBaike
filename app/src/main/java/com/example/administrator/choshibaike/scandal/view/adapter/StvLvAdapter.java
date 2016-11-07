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
import com.example.administrator.choshibaike.scandal.model.bean.StvBean;
import com.example.administrator.choshibaike.scandal.view.myview.MyImagView;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2016/11/1 0001.
 */
public class StvLvAdapter extends BaseAdapter {
    private List<StvBean> list;
    private Context context;
    private LayoutInflater inflater;
    private MediaPlayer player;
    //记录当前正在播放的item的position
    private int currentPosition = -1;
    public StvLvAdapter(List<StvBean> list, Context context) {
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
        MyviewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.stvf_items, parent, false);
            holder = new MyviewHolder();
            holder.iv = (MyImagView) convertView.findViewById(R.id.f0lviv);
            holder.iv0 = (ImageView) convertView.findViewById(R.id.iv1);
            holder.iv1 = (ImageView) convertView.findViewById(R.id.iv2);
            holder.iv2 = (ImageView) convertView.findViewById(R.id.iv3);
            holder.iv3 = (ImageView) convertView.findViewById(R.id.iv4);
            holder.hotiv = (ImageView) convertView.findViewById(R.id.f0lviv1);
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.content = (TextView) convertView.findViewById(R.id.content);
            holder.hot = (TextView) convertView.findViewById(R.id.hot);
            holder.count = (TextView) convertView.findViewById(R.id.count);

            holder.imgv = (ImageView) convertView.findViewById(R.id.imgv);
            holder.surfaceView = (SurfaceView) convertView.findViewById(R.id.surface_view);
            convertView.setTag(holder);
        } else {
            holder = (MyviewHolder) convertView.getTag();
        }
        StvBean bean = list.get(position);
        String id = bean.getUser().getId();
        if (id.length() > 0) {
            String s = id.substring(0, id.length() - 4);
            Picasso.with(context).load("http://pic.qiushibaike.com/system/avtnew/" + s + "/"
                    + id +"/thumb/"+bean.getUser().getIcon()).into(holder.iv);
        }
        holder.title.setText(bean.getUser().getLogin());
        String string = "好笑"+bean.getUp()+".评论"+bean.getComments_count()+".分享"+bean.getShare_count();
        holder.count.setText(string);

        Picasso.with(context).load(bean.getPic_url()).into(holder.imgv);
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
                String hign_url = bean.getHign_url();
                Log.d("wode_sa", "getView: " + hign_url);
                if (hign_url != null) {
                    player.setDataSource(hign_url);
                    player.prepareAsync();
                }

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

        holder.title.setText(bean.getUser().getLogin());
        holder.content.setText(bean.getContent());
        return convertView;
    }

    class MyviewHolder {
        ImageView iv0,iv1,iv2, iv3,imgv,hotiv;
        TextView title,content, count,hot;
        MyImagView iv;
        SurfaceView surfaceView;
    }
}
