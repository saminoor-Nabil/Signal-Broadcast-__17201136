package com.example.batteryinfo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    TextView textview;
    Button button;
    IntentFilter intentfilter;
    int deviceStatus;
    String currentBatteryStatus = "Battery Info";
    int batteryLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button2);
        textview = (TextView) findViewById(R.id.textView);

        intentfilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MainActivity.this.registerReceiver(broadcastreceiver, intentfilter);

            }
        });
    }

    private BroadcastReceiver broadcastreceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            deviceStatus = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
            int batteryLevel = (int) (((float) level / (float) scale) * 100.0f);
            if (deviceStatus == BatteryManager.BATTERY_STATUS_CHARGING) {

                textview.setText(currentBatteryStatus + " = Charging at " + batteryLevel + " %");

            }
        }
    };
}