package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;


import android.os.Bundle;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class Sendsms extends AppCompatActivity {

final int SEND_SMS_PERMISSION_REQUEST_CODE = 1;
    EditText mobileno, message;
    Button sendsms;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sendsms);


        mobileno = (EditText) findViewById(R.id.editText1);
        message = (EditText) findViewById(R.id.editText2);
        sendsms = (Button) findViewById(R.id.button1);


        sendsms.setEnabled(false);


        if(checkPermission(Manifest.permission.SEND_SMS)){

            sendsms.setEnabled(true);




            sendsms.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    String no = mobileno.getText().toString();
                    String msg = message.getText().toString();

                    //Getting intent and PendingIntent instance
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);

                    SmsManager sms = SmsManager.getDefault();
                    // sms.sendTextMessage("8802177690", null, "hello javatpoint", pi,null);


                    sms = SmsManager.getDefault();
                    sms.sendTextMessage(no, null, msg, pi, null);

                    Toast.makeText(getApplicationContext(), "Message Sent successfully!",
                            Toast.LENGTH_LONG).show();


                }



            });










        }

        else {

            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},SEND_SMS_PERMISSION_REQUEST_CODE);
        }

        //Performing action on button click


    }

    private boolean checkPermission(String sendSms) {

        int check= ContextCompat.checkSelfPermission(this,sendSms);
        return (check== PackageManager.PERMISSION_GRANTED);

    }
}




