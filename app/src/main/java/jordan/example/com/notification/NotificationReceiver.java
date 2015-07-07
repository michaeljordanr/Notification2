package jordan.example.com.notification;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class NotificationReceiver extends BroadcastReceiver {
    public static final String ACTION_BUTTON1 = "jordan.example.com.notification.action.ACTION_BUTTON_1";
    public static final String ACTION_BUTTON2 = "jordan.example.com.notification.action.ACTION_BUTTON_2";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        String msg;

        if(action.equals(ACTION_BUTTON1)){
            msg = context.getString(R.string.pressed_button1);
        }else if(action.equals(ACTION_BUTTON2)){
            msg = context.getString(R.string.pressed_button2);
        }else{
            msg = "Ação desconhecida";
        }

        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }
}
