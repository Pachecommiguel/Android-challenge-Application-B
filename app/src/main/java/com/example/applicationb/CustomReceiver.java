package com.example.applicationb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class CustomReceiver extends BroadcastReceiver {

    public static final String ACTION = "application.challenge.SEND_MESSAGE";
    private MessageListener listener;

    public CustomReceiver() {}

    public CustomReceiver(MessageListener listener) {
        this.listener = listener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String text = StringUtils.hexToUTF8(intent.getStringExtra(Intent.EXTRA_TEXT));
        listener.onMessage(text);
    }

    interface MessageListener {
        void onMessage(String message);
    }
}
