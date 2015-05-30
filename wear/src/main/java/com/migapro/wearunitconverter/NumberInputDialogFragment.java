package com.migapro.wearunitconverter;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;

public class NumberInputDialogFragment extends DialogFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_number_input, container, false);

        return view;
    }

    @Override
    public void onResume() {
        super.onStart();
        Window window = getDialog().getWindow();
        window.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL);
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, 120);
    }
}
