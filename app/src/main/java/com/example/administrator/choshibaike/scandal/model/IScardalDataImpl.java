package com.example.administrator.choshibaike.scandal.model;

import android.support.v4.app.Fragment;

import com.example.administrator.choshibaike.scandal.view.scandalfragment.STvFragment;
import com.example.administrator.choshibaike.scandal.view.scandalfragment.SchtFragment;
import com.example.administrator.choshibaike.scandal.view.scandalfragment.ScriemFragment;
import com.example.administrator.choshibaike.scandal.view.scandalfragment.SctFragment;
import com.example.administrator.choshibaike.scandal.view.scandalfragment.SthroughFragment;
import com.example.administrator.choshibaike.scandal.view.scandalfragment.SvipFragment;
import com.example.administrator.choshibaike.utils.Okhttpclient;
import com.example.administrator.choshibaike.utils.PerseJson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/11/1 0001.
 */
public class IScardalDataImpl implements IScardalData {


    @Override
    public void getStvfData(final OnDataLoadLisenter onDataLoadLisenter, String url) {
        Request request = new Request.Builder().url(url).build();
        Okhttpclient.getClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                onDataLoadLisenter.onFaild(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String s = response.body().string();
                    String string = s;
                    List<Object> lieJson = PerseJson.getJson(s);
                    onDataLoadLisenter.onSuccess(lieJson);
                }
            }
        });
    }
}
