package com.example.exemplesms;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SmsActivity extends AppCompatActivity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        context = this;

        final EditText txtSmsMessage = findViewById(R.id.txtSms);
        final EditText txtNumeroDestinataire = findViewById(R.id.txtNumeroDestinataire);
        Button btnSendSms = findViewById(R.id.btnSendSms);

        btnSendSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager smsManager = SmsManager.getDefault();
                String smsMessage = txtSmsMessage.getText().toString().trim();
                String numeroDestinataire = txtNumeroDestinataire.getText().toString().trim();

                Intent sendIntent = new Intent("SMS_SENT");
                Intent deliveredIntent = new Intent("SMS_DELIVERED");

                PendingIntent piSend = PendingIntent.getBroadcast(context,0,sendIntent,0);
                PendingIntent piDelivered = PendingIntent.getBroadcast(context,0,deliveredIntent,0);

                if(!smsMessage.isEmpty() && !numeroDestinataire.isEmpty())
                {
                    try{
                        smsManager.sendTextMessage(numeroDestinataire,null,smsMessage,piSend,piDelivered);
                    }
                    catch(Exception ex)
                    {
                        String messageError = ex.getMessage();
                    }
                }
            }
        });
    }
}
