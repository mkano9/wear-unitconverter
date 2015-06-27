package com.migapro.wearunitconverter.ui;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

import com.migapro.wearunitconverter.R;
import com.migapro.wearunitconverter.utility.Constants;

public class WearListActivity extends Activity implements WearListFragment.WearListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wear_list);

        loadFragment();
    }

    private void loadFragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment fragment = fm.findFragmentById(R.id.container);
        if (fragment == null) {
            String[] data = getIntent().getStringArrayExtra(Constants.KEY_LISTVIEW_DATA);
            fragment = WearListFragment.newInstance(data);
        }
        ft.add(R.id.container, fragment);
        ft.commit();
    }

    @Override
    public void onListItemSelected(int position) {
        Intent intent = getIntent();
        intent.putExtra(Constants.KEY_ITEM_SELECTED_POSITION, position);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
