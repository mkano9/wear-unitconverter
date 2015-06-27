package com.migapro.wearunitconverter.ui;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.wearable.view.WearableListView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.migapro.wearunitconverter.R;
import com.migapro.wearunitconverter.utility.Constants;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class WearListFragment extends Fragment implements WearableListView.ClickListener {

    @InjectView(R.id.wear_listview) WearableListView wearableListView;

    private WearListListener mListener;

    public interface WearListListener {
        public void onListItemSelected(int position);
    }

    public static Fragment newInstance(String[] data) {
        Fragment fragment = new WearListFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArray(Constants.KEY_DATA_LIST, data);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_wear_list, container, false);
        ButterKnife.inject(this, rootView);

        String[] data = getArguments().getStringArray(Constants.KEY_DATA_LIST);
        wearableListView.setAdapter(new UnitWearListAdapter(getActivity(), data));
        wearableListView.setClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(WearableListView.ViewHolder v) {
        mListener.onListItemSelected(v.getPosition());
    }

    @Override
    public void onTopEmptyRegionClick() {
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mListener = (WearListListener) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
