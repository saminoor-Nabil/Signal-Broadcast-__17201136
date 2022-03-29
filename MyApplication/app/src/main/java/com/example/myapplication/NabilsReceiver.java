package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class NabilsReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

        if ("com.example.EXAMPLE_ACTION".equals(intent.getAction())) {
            String receivedText = intent.getStringExtra("com.example.EXTRA_TEXT");
            Toast.makeText(context, receivedText, Toast.LENGTH_SHORT).show();

        }
    }
}