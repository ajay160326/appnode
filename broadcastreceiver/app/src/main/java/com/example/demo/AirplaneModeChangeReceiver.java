package com.example.demo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class AirplaneModeChangeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // logic
        if(isAirplaneModeOn(context.getApplicationContext())) {
            Toast.makeText(context, "Airplane Mode is On", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Airplane Mode is Off", Toast.LENGTH_SHORT).show();
        }
    }

    private static boolean isAirplaneModeOn(Context context) {
        return Settings.System.getInt(context.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON, 0) != 0;
    }
}