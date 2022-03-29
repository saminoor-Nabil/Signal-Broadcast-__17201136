package com.example.broadcastsender;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text2);
    }
    public void sendBroadcast(View v) {
        Intent intent = new Intent("com.example.EXAMPLE_ACTION");
        intent.putExtra("com.example.EXTRA_TEXT", "Broadcast received");
        sendBroadcast(intent);
    }
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String receivedText = intent.getStringExtra("com.example.EXTRA_TEXT");
            textView.setText(receivedText);
        }
    };
    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter("com.example.EXAMPLE_ACTION");
        registerReceiver(broadcastReceiver, filter);
    }
    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadcastReceiver);
    }
}