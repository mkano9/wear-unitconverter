package com.migapro.wearunitconverter.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.WearableListView;
import android.widget.Toast;

import com.migapro.wearunitconverter.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class UnitListActivity extends Activity implements WearableListView.ClickListener {

    @InjectView(R.id.wear_listview) WearableListView wearableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_list);

        ButterKnife.inject(this);

        // TODO Receive units list from intent
        String[] data = getResources().getStringArray(R.array.length_units);
        wearableListView.setAdapter(new UnitWearListAdapter(this, data));
        wearableListView.setClickListener(this);
    }

    @Override
    public void onClick(WearableListView.ViewHolder v) {
        Toast.makeText(UnitListActivity.this, "TEST", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTopEmptyRegionClick() {
    }
}
