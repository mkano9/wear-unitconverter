package com.migapro.wearunitconverter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

public class NumberPadGridAdapter extends BaseAdapter {

    private String[] mKeys;
    private LayoutInflater inflater;

    public NumberPadGridAdapter(Context context) {
        mKeys = context.getResources().getStringArray(R.array.number_pad_keys);
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mKeys.length;
    }

    @Override
    public Object getItem(int position) {
        return mKeys[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Button cellView = (Button) convertView;

        if (cellView == null) {
            cellView = (Button)inflater.inflate(R.layout.number_pad_cell, parent, false);
        }

        cellView.setText(mKeys[position]);

        return cellView;
    }
}
