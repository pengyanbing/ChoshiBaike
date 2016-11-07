package com.example.administrator.choshibaike.scandal.view.scandalfragment;

import com.example.administrator.choshibaike.scandal.model.bean.StvBean;
import com.example.administrator.choshibaike.scandal.view.adapter.ScardalVpAdapter;
import com.example.administrator.choshibaike.scandal.view.adapter.SchtLvAdapter;
import com.example.administrator.choshibaike.scandal.view.adapter.SivpLvAdapter;
import com.example.administrator.choshibaike.scandal.view.adapter.StvLvAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/11/1 0001.
 */
public interface IScardalView {

    public void scrdaIvplvSetAdapter(SivpLvAdapter adapter);
    public void stvLvSetAdapter(StvLvAdapter adapter);


}
