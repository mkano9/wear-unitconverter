package com.migapro.wearunitconverter.ui;

import android.content.Context;
import android.support.wearable.view.WearableListView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.migapro.wearunitconverter.R;

public class UnitWearListAdapter extends WearableListView.Adapter {

    private LayoutInflater mInflater;
    private String[] mData;

    public UnitWearListAdapter(Context context, String[] data) {
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mData = data;
    }

    @Override
    public WearableListView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WearableListView.ViewHolder(mInflater.inflate(R.layout.unit_list_item, null));
    }

    @Override
    public void onBindViewHolder(WearableListView.ViewHolder holder, int position) {
        TextView text = (TextView) holder.itemView.findViewById(R.id.row_text);
        text.setText(mData[position]);
        holder.itemView.setTag(mData[position]);
    }

    @Override
    public int getItemCount() {
        return mData.length;
    }
}