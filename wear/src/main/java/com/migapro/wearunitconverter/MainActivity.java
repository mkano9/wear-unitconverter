package com.migapro.wearunitconverter;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @InjectView(R.id.unit_from) TextView unitFromLabel;
    @InjectView(R.id.num_from) TextView numFromLabel;
    @InjectView(R.id.unit_to) TextView unitToLabel;
    @InjectView(R.id.num_to) TextView numToLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);
    }

    @OnClick(R.id.unit_from)
    public void onUnitFromClick() {
        Toast.makeText(getApplicationContext(), "unit from", Toast.LENGTH_SHORT).show();
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
}
