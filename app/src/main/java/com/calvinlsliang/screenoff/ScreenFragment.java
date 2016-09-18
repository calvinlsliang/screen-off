package com.calvinlsliang.screenoff;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;

public class ScreenFragment extends Fragment {

    final static String IS_STARTED = "isChecked";
    final ToggleManager manager = ToggleManager.getInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_screen, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initializeSwitchListener();
    }

    private void initializeSwitchListener() {
        Switch toggle = (Switch) getView().findViewById(R.id.toggle_switch);

        boolean isServiceStarted = manager.isServiceStarted(getActivity());
        toggle.setChecked(isServiceStarted);

        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                manager.setIsServiceStarted(getActivity(), isChecked);
                toggleService(isChecked);
            }
        });
    }

    private void toggleService(boolean isChecked) {
        Intent intent = new Intent(getActivity(), ToggleScreenService.class);
        intent.putExtra(IS_STARTED, isChecked);
        getActivity().startService(intent);

    }
}
