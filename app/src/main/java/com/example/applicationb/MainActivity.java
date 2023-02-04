package com.example.applicationb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;

import com.example.applicationb.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements CustomReceiver.MessageListener {

    private CustomReceiver receiver;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setProperties();
        setContentView(binding.getRoot());
        setReceiver();
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(receiver);
        super.onDestroy();
    }

    @Override
    public void onMessage(String message) {
        binding.message.setText(message);
    }

    private void setProperties() {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        receiver = new CustomReceiver(this);
    }

    private void setReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(CustomReceiver.ACTION);
        registerReceiver(receiver, intentFilter);
    }
}