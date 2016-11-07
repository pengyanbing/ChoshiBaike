package com.example.administrator.choshibaike.scandal.model;

import com.example.administrator.choshibaike.utils.Okhttpclient;
import com.example.administrator.choshibaike.utils.PerseJson;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/11/3 0003.
 */
public class ITopicDataImpl implements ITopicData {
    @Override
    public void getTopicData(final OnDataLoadLisenter onDataLoadLisenter, String url) {
        Request request = new Request.Builder().url(url).build();
        Okhttpclient.getClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                onDataLoadLisenter.onFaild(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String string = response.body().string();
                    List<Object> list = PerseJson.gettopicData(string);
                    onDataLoadLisenter.onSuccess(list);

                }
            }
        });
    }
}
