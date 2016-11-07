package com.example.administrator.choshibaike.scandal.view;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.administrator.choshibaike.BaseActivity;
import com.example.administrator.choshibaike.R;
import com.example.administrator.choshibaike.scandal.view.friendfragment.FriendFragment;
import com.example.administrator.choshibaike.scandal.view.mine_paper.MineF;
import com.example.administrator.choshibaike.scandal.view.mine_paper.PaperF;
import com.example.administrator.choshibaike.scandal.view.scandalfragment.ScandalFragment;
import com.example.administrator.choshibaike.scandal.view.seedingfragment.SeedingFragment;

public class MainActivity extends BaseActivity {

    public LinearLayout linearLayout;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        transaction = getSupportFragmentManager().beginTransaction();
        ScandalFragment fragment = new ScandalFragment();
        transaction.replace(R.id.linearlayout, fragment);
        transaction.commit();
    }

    public void scardalonclick(View view) {
        transaction = getSupportFragmentManager().beginTransaction();
        ScandalFragment fragment =  new ScandalFragment();
        transaction.replace(R.id.linearlayout, fragment);
        transaction.commit();
    }

    public void friendonclick(View view) {
        FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
        FriendFragment fragment = new FriendFragment();
        transaction1.replace(R.id.linearlayout, fragment);
        transaction1.commit();
    }

    public void directonclick(View view) {
        FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
        SeedingFragment fragment = new SeedingFragment();
        transaction1.replace(R.id.linearlayout, fragment);
        transaction1.commit();
    }

    public void notiesonclick(View view) {
        FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
        PaperF fragment = new PaperF();
        transaction1.replace(R.id.linearlayout, fragment);
        transaction1.commit();
    }

    public void myonclick(View view) {
        FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
        MineF fragment = new MineF();
        transaction1.replace(R.id.linearlayout, fragment);
        transaction1.commit();
    }
}
