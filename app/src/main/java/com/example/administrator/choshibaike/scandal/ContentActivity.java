package com.example.administrator.choshibaike.scandal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.choshibaike.R;
import com.example.administrator.choshibaike.scandal.presenger.ContentPresenger;
import com.example.administrator.choshibaike.scandal.view.IContenView;
import com.example.administrator.choshibaike.scandal.view.adapter.ContentLvaAdapter;
import com.example.administrator.choshibaike.scandal.view.myview.MyImagView;
import com.squareup.picasso.Picasso;

import java.util.zip.Inflater;

public class ContentActivity extends AppCompatActivity implements IContenView{

    public ListView lv;
    private ContentPresenger presenger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        lv = ((ListView) findViewById(R.id.contentlv));
        LayoutInflater inflater = LayoutInflater.from(this);
        View healder = inflater.inflate(R.layout.contentlvhealder, null);
        MyImagView iv = (MyImagView) healder.findViewById(R.id.f0lviv);
        ImageView img = (ImageView) healder.findViewById(R.id.img);
        TextView title = (TextView) healder.findViewById(R.id.title);
        TextView content = (TextView) healder.findViewById(R.id.content);
        TextView count = (TextView) healder.findViewById(R.id.count);
        Intent intent = getIntent();
        String path = intent.getStringExtra("path");
        String path1 = intent.getStringExtra("path1");
        String content1 = intent.getStringExtra("content");
        String login = intent.getStringExtra("login");
        String string = intent.getStringExtra("string");
        String id = intent.getStringExtra("id");
        Picasso.with(this).load(path).into(iv);
        title.setText(login);
        count.setText(string);
        if (path1.length() > 0) {
            Picasso.with(this).load(path1).into(img);
        }

        content.setText(content1);
        String url = "http://m2.qiushibaike.com/article/" + id + "/comment/author?page=1&count=50&rqcnt=36&r=53022f631477962381070";
        presenger = new ContentPresenger(this, this, url);
        lv.addHeaderView(healder);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenger.start();
    }

    @Override
    public void contentlvSetAdapter(ContentLvaAdapter adapter) {
        lv.setAdapter(adapter);
    }
}
