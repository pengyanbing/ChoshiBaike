package com.example.administrator.choshibaike.scandal.model;

import java.util.List;

/**
 * Created by Administrator on 2016/11/1 0001.
 */
public interface OnDataLoadLisenter {
    void onSuccess(List<Object> list);

    void onFaild(String msg);
}
