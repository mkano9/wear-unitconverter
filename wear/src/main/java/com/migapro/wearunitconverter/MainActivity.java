package com.migapro.wearunitconverter;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView unitFrom = (TextView) findViewById(R.id.unit_from);
        unitFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "unit from", Toast.LENGTH_SHORT).show();
            }
        });

        TextView numFrom = (TextView) findViewById(R.id.num_from);
        numFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "number from", Toast.LENGTH_SHORT).show();
                FragmentManager fm = getFragmentManager();
                NumberInputDialogFragment numberInputDialog = new NumberInputDialogFragment();
                numberInputDialog.show(fm, "fragment_number_input");
            }
        });

        TextView unitTo = (TextView) findViewById(R.id.unit_to);
        unitTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "unit to", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
