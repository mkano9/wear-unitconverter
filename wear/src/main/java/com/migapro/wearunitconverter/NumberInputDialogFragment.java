package com.migapro.wearunitconverter;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnItemClick;

public class NumberInputDialogFragment extends DialogFragment {

    @InjectView(R.id.gridview) GridView gridView;

    private OnKeyboardPressListener listener;

    public interface OnKeyboardPressListener {
        public void onKeyPress(String key);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_number_input, container, false);

        ButterKnife.inject(this, view);

        gridView.setAdapter(new NumberPadGridAdapter(getActivity()));

        return view;
    }

    @OnItemClick(R.id.gridview)
    public void onGridViewItemClick(View view) {
        listener.onKeyPress(((Button) view).getText().toString());
    }

    @Override
    public void onResume() {
        super.onStart();
        Window window = getDialog().getWindow();
        window.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL);
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, 120); //TODO want 55% height
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        listener = (OnKeyboardPressListener) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
