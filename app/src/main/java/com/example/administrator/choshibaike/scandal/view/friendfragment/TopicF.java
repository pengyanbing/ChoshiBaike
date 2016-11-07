package com.example.administrator.choshibaike.scandal.view.friendfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.administrator.choshibaike.BaseFragment;
import com.example.administrator.choshibaike.R;
import com.example.administrator.choshibaike.scandal.presenger.friend.TopicPresenger;
import com.example.administrator.choshibaike.scandal.view.adapter.TopicAdapter;

/**
 * Created by Administrator on 2016/11/3 0003.
 */
public class TopicF extends BaseFragment implements TopicView {
    public ListView lv;
    private Context context;
    public TopicPresenger presenger;

    public TopicF(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.topicfg, container, false);
        lv = ((ListView) view.findViewById(R.id.topiclv));
        presenger = new TopicPresenger(this,context);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("wode_sa", "onResume: pppppppppppppppppppppppp");
        presenger.start();
    }

    @Override
    public void lvsetAdapter(TopicAdapter adapter) {
        lv.setAdapter(adapter);
    }
}
