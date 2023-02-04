package com.example.applicationb.components;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;

import com.example.applicationb.utils.IntentAction;
import com.example.applicationb.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private final MessageBroadcastReceiver receiver = new MessageBroadcastReceiver((message) ->
            binding.message.setText(message)
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setReceiver();
    }

    @Override
    protected void onStop() {
        unregisterReceiver(receiver);
        super.onStop();
    }

    private void setReceiver() {
        IntentFilter intentFilter = new IntentFilter(IntentAction.MESSAGE_SEND.getAction());
        registerReceiver(receiver, intentFilter);
    }
}