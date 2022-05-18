package com.duksung.local;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NoticeActivity extends AppCompatActivity {
    ListView mListView = null;
    BaseAdapterEx mAdapter = null;
    ArrayList<Notice> mData = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        //어댑터에서 사용할 데이터 설정
        mData = new ArrayList<Notice>();

        Notice notice = new Notice();

        mData.add(notice);

        mAdapter = new BaseAdapterEx(this, mData);

        mListView = (ListView) findViewById(R.id.lt_listview);
        mListView.setAdapter(mAdapter);
    }
}