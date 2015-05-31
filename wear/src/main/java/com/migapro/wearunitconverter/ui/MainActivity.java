package com.migapro.wearunitconverter.ui;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.migapro.wearunitconverter.R;
import com.migapro.wearunitconverter.model.NumberPadKey;
import com.migapro.wearunitconverter.utility.Constants;
import com.migapro.wearunitconverter.utility.NumberPadUtility;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.OnLongClick;

public class MainActivity extends Activity implements NumberInputDialogFragment.NumberInputDialogListener {

    @InjectView(R.id.unit_from) TextView unitFromLabel;
    @InjectView(R.id.num_from) TextView numFromLabel;
    @InjectView(R.id.unit_to) TextView unitToLabel;
    @InjectView(R.id.num_to) TextView numToLabel;

    private String mNumberFrom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);

        mNumberFrom = "0";
    }

    @OnClick(R.id.unit_from)
    public void onUnitFromClick() {
        Intent intent = new Intent(this, UnitListActivity.class);
        startActivityForResult(intent, Constants.REQUEST_CODE_UNIT_FROM);
    }

    @OnLongClick(R.id.unit_from)
    public boolean onUnitFromLongClick() {
        Intent intent = new Intent(this, UnitListActivity.class);
        startActivity(intent);
        return true;
    }

    @OnClick(R.id.num_from)
    public void onNumFromClick() {
        FragmentManager fm = getFragmentManager();
        NumberInputDialogFragment numberInputDialog = new NumberInputDialogFragment();
        numberInputDialog.show(fm, "fragment_number_input");
    }

    @OnClick(R.id.unit_to)
    public void onUnitToClick() {
        Toast.makeText(getApplicationContext(), "unit to", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != Activity.RESULT_OK) {
            return;
        }

        if (requestCode == Constants.REQUEST_CODE_UNIT_FROM) {
            String unitSelected = data.getStringExtra(Constants.ITEM_SELECTED_KEY);
            unitFromLabel.setText(unitSelected);
        }
    }

    @Override
    public void onKeyPress(NumberPadKey key) {
        mNumberFrom = key.processKey(mNumberFrom);
        numFromLabel.setText(mNumberFrom);
    }

    @Override
    public void onDismiss() {
        if (NumberPadUtility.isLastCharPeriod(mNumberFrom)) {
            mNumberFrom = mNumberFrom.substring(0, mNumberFrom.length() - 1);
            numFromLabel.setText(mNumberFrom);
        }

        if (NumberPadUtility.isNegativeZero(mNumberFrom)) {
            mNumberFrom = "0";
            numFromLabel.setText(mNumberFrom);
        }
    }
}
