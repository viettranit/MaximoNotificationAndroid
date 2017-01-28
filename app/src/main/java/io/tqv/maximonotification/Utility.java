package io.tqv.maximonotification;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.firebase.messaging.FirebaseMessaging;

/**
 * Created by Viet on 1/15/2017.
 */

public class Utility {
    public static String getRegisteredTopic(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(context.getString(R.string.pref_topic_key),
                context.getString(R.string.pref_topic_default));
    }
}
