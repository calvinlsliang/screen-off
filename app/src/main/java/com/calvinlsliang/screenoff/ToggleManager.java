package com.calvinlsliang.screenoff;


import android.content.Context;
import android.preference.PreferenceManager;

public class ToggleManager {

    private static ToggleManager instance;
    private static String IS_SCREEN_OFF = "IS_SCREEN_OFF";

    private ToggleManager() {}

    public static ToggleManager getInstance() {
        if (instance == null) {
            instance = new ToggleManager();
        }
        return instance;
    }

    public boolean isServiceStarted(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(IS_SCREEN_OFF, false);
    }

    public void setIsServiceStarted(Context context, boolean isStarted) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean(IS_SCREEN_OFF, isStarted).apply();
    }
}
