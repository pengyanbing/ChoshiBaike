package com.example.administrator.choshibaike.scandal.view.scandalfragment;

        import android.content.Context;
        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ListView;
        import android.widget.TextView;

        import com.example.administrator.choshibaike.BaseFragment;
        import com.example.administrator.choshibaike.R;
        import com.example.administrator.choshibaike.scandal.model.bean.StvBean;
        import com.example.administrator.choshibaike.scandal.presenger.Shtfpresenter;
        import com.example.administrator.choshibaike.scandal.view.adapter.SchtLvAdapter;

        import java.util.List;

/**
 * Created by Administrator on 2016/11/1 0001.
 */
public class SchtFragment extends BaseFragment implements Ischtf {
    private ListView lv;
    public View view;
    private Context context;
    public Shtfpresenter shtfpresenter;

    public SchtFragment(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.schtfragment, container, false);
        lv = (ListView) view.findViewById(R.id.lv);
        shtfpresenter = new Shtfpresenter(this, context);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        shtfpresenter.start();
    }

    public ListView getLv() {
        return lv;
    }

    @Override
    public void schtLvSetAdapter(SchtLvAdapter adapter) {
        lv.setAdapter(adapter);
    }

}
