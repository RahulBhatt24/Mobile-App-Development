package com.example.saicm.textingai;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView textView;
    int currentstate;

    BroadcastReceiver broadcastReceiver;
    static String phoneNumber;
    Handler handler = new Handler();
    SmsManager manager = SmsManager.getDefault();

    String[][] aimessages = new String[][]{{"Hi this is Dominos, what would you like to order?","Hi what would you like to order?", "Hi this is Dominos how may I help you today?"},
                                           {"Okay. What kind of pizza would you like?", "Sure, what pizza would you like to order?", "We have a 15% off deal for cheese pizza today."},
                                           {"Great, what size would you like that in?", "Sounds good, do you want a small, medium, or large?", "Okay, do you want to take that in a small, medium, or large?"},
                                           {"Okay your total comes out to $7.99.", "Okay your total comes to $9.99.", "Okay your total comes out to $11.99"},
                                           {"Can I have your name and address please?", "Alright, what is your name and address?", "Okay, can I have your name and address?"},
                                           {"Awesome, we are getting your order ready.", "Okay, your order should be delivered in 15 minutes", "Great, your order will arrive in about 10 minutes"}};

    @Override
    protected void onResume() {
        super.onResume();

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
        registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(broadcastReceiver);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECEIVE_SMS}, 0);
        }

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 0);
        }

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_SMS}, 0);
        }

        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Bundle bundle = intent.getExtras();
                SmsMessage [] messages = null;

                if (bundle != null) {

                    Object [] pdus = (Object[]) bundle.get("pdus");

                    messages = new SmsMessage[pdus.length];

                    for (int i = 0; i < messages.length; i++) {
                        messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i], (String) bundle.get("format"));

                        String message = messages[i].getMessageBody();
                        phoneNumber = messages[i].getOriginatingAddress();
                        textView.setText(message);
                        runTextingAi(message);
                    }
                }
            }
        };
    }

    public void sendText(final String message, int time) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                manager.sendTextMessage(phoneNumber, null, message, null, null);
            }
        }, time);
    }

    public void runTextingAi(String message) {
        if (currentstate == 0 && (message.toLowerCase().equals("hey") || message.toLowerCase().equals("hello") || message.toLowerCase().equals("hi"))) {
            sendText(aimessages[currentstate][(int)(Math.random())+2], 5000);
            currentstate++;
        } else if (currentstate == 1 && (message.toLowerCase().equals("i would like to order a pizza") || message.toLowerCase().equals("i would like to order some food") || message.toLowerCase().equals("pizza"))) {
            sendText(aimessages[currentstate][(int)(Math.random()+2)], 5000);
            currentstate++;
        } else if (currentstate == 2 && (message.toLowerCase().equals("i'll take that") || message.toLowerCase().equals("i want a cheese pizza") || message.toLowerCase().equals("i would like a pepperoni"))) {
            sendText(aimessages[currentstate][(int)(Math.random()+2)], 5000);
            currentstate++;
        } else if (currentstate == 3 && (message.toLowerCase().equals("small") || message.toLowerCase().equals("medium") || message.toLowerCase().equals("large"))) {
            sendText(aimessages[currentstate][(int)(Math.random()+2)], 5000);
            currentstate++;
        } else if (currentstate == 4 && (message.toLowerCase().equals("okay") || message.toLowerCase().equals("sounds good") || message.toLowerCase().equals("alright"))) {
            sendText(aimessages[currentstate][(int)(Math.random()+2)], 5000);
            currentstate++;
        } else if (currentstate == 5) {
            sendText(aimessages[currentstate][(int)(Math.random()+2)], 5000);
            currentstate++;
        } else {
            sendText("Sorry, I don't understand that.", 5000);
        }

    }
}
