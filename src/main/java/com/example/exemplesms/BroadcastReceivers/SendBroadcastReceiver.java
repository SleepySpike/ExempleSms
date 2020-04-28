package com.example.exemplesms.BroadcastReceivers;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.widget.Toast;

import com.example.exemplesms.R;
import com.example.exemplesms.Utilities.Functions;

public class SendBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();

        if(action.equals("SMS_SENT"))
        {
            int code = getResultCode();

            switch (code)
            {
                case Activity.RESULT_OK : //Toast.makeText(context,"SMS Sent", Toast.LENGTH_LONG).show();
                    Functions.getNotification(context,"Envoi SMS","Message bien envoyé");
                break;

                case SmsManager.RESULT_ERROR_GENERIC_FAILURE : Toast.makeText(context,"Erreur d'envoi", Toast.LENGTH_LONG).show();
                break;

                default: Toast.makeText(context,"Autre cas d'erreur", Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }

}
