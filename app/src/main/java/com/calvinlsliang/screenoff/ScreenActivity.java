package com.calvinlsliang.screenoff;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);

        Fragment fragment = new ScreenFragment();
        FragmentManager manager = getFragmentManager();

        manager.beginTransaction().add(R.id.fragment_container, fragment).commit();
    }
}
