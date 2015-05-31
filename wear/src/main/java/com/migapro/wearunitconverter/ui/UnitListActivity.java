package com.migapro.wearunitconverter.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.view.WearableListView;

import com.migapro.wearunitconverter.R;
import com.migapro.wearunitconverter.utility.Constants;

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
        Intent intent = getIntent();
        intent.putExtra(Constants.ITEM_SELECTED_KEY, v.itemView.getTag().toString());
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    @Override
    public void onTopEmptyRegionClick() {
    }
}
