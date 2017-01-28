package io.tqv.maximonotification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

import com.google.firebase.messaging.FirebaseMessaging;

public class MyReceiver extends BroadcastReceiver {

    private static String mRegisteredTopic;
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, MainActivity.class);
        context.startService(i);
    }
}