package com.duksung.local;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class BaseAdapterEx extends BaseAdapter {
    Context mContext = null;
    ArrayList<Notice> mData = null;
    LayoutInflater mLayoutInflater = null;

    public BaseAdapterEx(Context context, ArrayList<Notice> data) {
        mContext = context;
        mData = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    public int getCount() { return mData.size(); }
    public long getItemId(int position) { return position; }
    public Object getItem(int position) { return  mData.get(position); }
    public View getView(int position, View convertView, ViewGroup parent) {

        View itemLayout = mLayoutInflater.inflate(R.layout.notice, null);

        TextView nameTv = (TextView) itemLayout.findViewById(R.id.tv_name);
        TextView messageTv = (TextView) itemLayout.findViewById(R.id.tv_message);
        TextView timeTv = (TextView) itemLayout.findViewById(R.id.tv_time);

//        nameTv.setText(mData.get(position).mName);

        return itemLayout;
    }
}
