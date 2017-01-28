package io.tqv.maximonotification;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;

public class MainActivity extends ActionBarActivity {

    public static final String LOG_TAG = MainActivity.class.getSimpleName();

    public static String mRegisteredTopic = "MAXADMIN";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerTopic(mRegisteredTopic);

        String link = getIntent().getStringExtra("link");
        if (link != null) {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(link));
            startActivity(i);
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, SettingActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();

        String topic = Utility.getRegisteredTopic( this );
        registerTopic(topic);
    }

    private void registerTopic(String topic) {
        if (mRegisteredTopic != null)
            FirebaseMessaging.getInstance().unsubscribeFromTopic(mRegisteredTopic);

        mRegisteredTopic = topic.toUpperCase();
        FirebaseMessaging.getInstance().subscribeToTopic(mRegisteredTopic);

        ((TextView) findViewById(R.id.main_textview)).setText("Subscribed to: " + mRegisteredTopic);
    }

}
