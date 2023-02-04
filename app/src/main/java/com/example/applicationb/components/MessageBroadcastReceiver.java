package com.example.applicationb.components;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.applicationb.utils.IntentAction;
import com.example.applicationb.utils.StringUtils;

public class MessageBroadcastReceiver extends BroadcastReceiver {

    private final MessageListener listener;

    public MessageBroadcastReceiver(MessageListener listener) {
        this.listener = listener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent replyIntent = new Intent(IntentAction.MESSAGE_RESULT.getAction()).putExtra(
                IntentAction.RESULT.getAction(),
                false
        );

        if (IntentAction.MESSAGE_SEND.getAction().equals(intent.getAction())) {
            String message = intent.getStringExtra(IntentAction.MESSAGE.getAction());

            if (message != null) {
                listener.onMessage(StringUtils.hexToUTF8(message));
                replyIntent.putExtra(IntentAction.RESULT.getAction(), true);
            }
        }

        context.sendBroadcast(replyIntent);
    }

    interface MessageListener {
        void onMessage(String message);
    }
}
