package com.example.administrator.choshibaike.scandal.presenger;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import com.example.administrator.choshibaike.scandal.model.IScardalData;
import com.example.administrator.choshibaike.scandal.model.IScardalDataImpl;
import com.example.administrator.choshibaike.scandal.model.OnDataLoadLisenter;
import com.example.administrator.choshibaike.scandal.model.bean.StvBean;
import com.example.administrator.choshibaike.scandal.view.adapter.SchtLvAdapter;
import com.example.administrator.choshibaike.scandal.view.scandalfragment.IScardalView;
import com.example.administrator.choshibaike.scandal.view.scandalfragment.Ischtf;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/2 0002.
 */
public class Shtfpresenter {
    private IScardalData iScardalData;
    private Ischtf ischtf;
    private Context context;
    private Handler mHandler = new Handler();

    public Shtfpresenter(Ischtf ischtf, Context context) {
        this.ischtf = ischtf;
        this.context = context;
        iScardalData = new IScardalDataImpl();
    }

   public void start() {
             iScardalData.getStvfData(new OnDataLoadLisenter() {
           @Override
           public void onSuccess(List<Object> list) {
               final List<StvBean> list1 = new ArrayList<StvBean>();
               for (int i = 0; i < list.size(); i++) {
                   list1.add((StvBean) list.get(i));
               }
               Log.d("wode_sa", "onSuccess: " + list1.size());
               Log.d("wode_sa", "onSuccess: +++++++++++");
               mHandler.post(new Runnable() {
                   @Override
                   public void run() {
                       ischtf.schtLvSetAdapter(new SchtLvAdapter(list1,context));
                   }
               });

           }

           @Override
           public void onFaild(String msg) {

           }
       }, "http://m2.qiushibaike.com/article/list/text?page=1&count=30&readarticles=[117878292,117880697,117879636,117880064,117880008,117879647,1178");
   }

}
