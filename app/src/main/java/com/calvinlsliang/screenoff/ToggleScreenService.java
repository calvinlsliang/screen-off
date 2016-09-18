package com.calvinlsliang.screenoff;


import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class ToggleScreenService extends Service {

    final static String SERVICE_NAME = "ToggleScreenService";

    private boolean serviceStarted = false;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        final boolean isStarted = intent.getBooleanExtra(ScreenFragment.IS_STARTED, false);

        Toast.makeText(this, isStarted ? "Service starting" : "Service stopping", Toast.LENGTH_SHORT).show();

        startService(isStarted);


        return super.onStartCommand(intent,flags,startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopService();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void startService(boolean isStarted) {

        if (!serviceStarted && isStarted) {
            serviceStarted = true;

            Notification noti = new Notification.Builder(getBaseContext())
                    .setContentTitle("Hello title")
                    .setContentText("Hello text")
                    .setSmallIcon(android.R.mipmap.sym_def_app_icon)
                    .build();

            startForeground(1, noti);

        } else {
            stopService();
        }
    }

    private void stopService() {
        if (serviceStarted) {
            serviceStarted = false;
            stopForeground(true);
        }
    }
}
