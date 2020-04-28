package com.example.exemplesms.BroadcastReceivers;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.widget.Toast;

public class DeliveryBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();

        if(action.equals("SMS_DELIVERED"))
        {
            int code = getResultCode();

            switch (code)
            {
                case Activity.RESULT_OK : Toast.makeText(context,"SMS bien récéptionné", Toast.LENGTH_LONG).show();
                    break;

                case Activity.RESULT_CANCELED : Toast.makeText(context,"Erreur de réception", Toast.LENGTH_LONG).show();
                    break;

                default: Toast.makeText(context,"Autre cas d'erreur", Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }
}
