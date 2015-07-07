package jordan.example.com.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void notify(View view){
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle(getString(R.string.notification));
        builder.setContentText(getString(R.string.receive_notification));
        builder.setSmallIcon(android.R.drawable.sym_action_chat);

        Intent intent = new Intent(this, MessageActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
        builder.setContentIntent(pi);
        builder.setAutoCancel(true);

        builder.setVisibility(Notification.VISIBILITY_PUBLIC);
        builder.setPriority(Notification.PRIORITY_MAX);
        builder.setDefaults(Notification.DEFAULT_ALL);

        Notification n = builder.build();

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(100, n);
    }

    public void notify2(View view){
        Notification.Builder builder = new Notification.Builder(this);
        builder.setSmallIcon(android.R.drawable.sym_action_chat);
        builder.setAutoCancel(true);

        Notification.BigTextStyle style = new Notification.BigTextStyle()
                .setBigContentTitle(getString(R.string.notification))
                .bigText(getString(R.string.receive_notification));
        builder.setStyle(style);

        Intent intent1 = new Intent(this, NotificationReceiver.class);
        intent1.setAction(NotificationReceiver.ACTION_BUTTON1);
        PendingIntent pi1 = PendingIntent.getBroadcast(this, 0, intent1, 0);

        Intent intent2 = new Intent(this, NotificationReceiver.class);
        intent1.setAction(NotificationReceiver.ACTION_BUTTON2);
        PendingIntent pi2 = PendingIntent.getBroadcast(this, 0, intent1, 0);

        builder.addAction(android.R.drawable.ic_menu_view, getString(R.string.button1), pi1);
        builder.addAction(android.R.drawable.ic_menu_view, getString(R.string.button2), pi2);


        Notification n = builder.build();
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(100, n);
    }

}
