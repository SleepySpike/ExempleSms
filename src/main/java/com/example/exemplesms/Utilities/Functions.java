package com.example.exemplesms.Utilities;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.example.exemplesms.R;
import com.example.exemplesms.SmsActivity;

public class Functions {

    public static void getNotification(Context context, String titre, String message)
    {
        Intent intent = new Intent(context, SmsActivity.class);

        PendingIntent pIntent = PendingIntent.getActivity(context, (int) System.currentTimeMillis(), intent, 0);

        Notification notification = new Notification.Builder(context)
                .setContentTitle(titre)
                .setContentText(message)
                .setSmallIcon(R.drawable.ic_action_notif)
                .setContentIntent(pIntent)
                .build();

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notification.flags |= Notification.FLAG_AUTO_CANCEL;

        notificationManager.notify(0,notification);
    }


}
