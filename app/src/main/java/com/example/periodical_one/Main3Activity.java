package com.example.periodical_one;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener{
    TextView t1;
    Button sendsms;
    String Score1="";
    String num="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Bundle b=getIntent().getExtras();
        String num=b.getString("num");
        Score1=b.getString("Score");
        //final String number=num;
        t1=(TextView)findViewById(R.id.msg);
        String test = "\nPhone Number:  "+ num +
                " \n\nScore  :  "+ Score1;
        t1.setText(test);
        sendsms=(Button)findViewById(R.id.sms);
        sendsms.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String msg=String.valueOf(Score1);
        //Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        Bundle b=getIntent().getExtras();
        num=b.getString("num");
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        PendingIntent pi=PendingIntent.getActivity(getApplicationContext(), 0, intent,0);
//Get the SmsManager instance and call the sendTextMessage method to send message
        SmsManager sms=SmsManager.getDefault();
        sms.sendTextMessage(num, null, msg, pi,null);
        Toast.makeText(getApplicationContext(), "Message Sent successfully!",
                Toast.LENGTH_LONG).show();


    }
}
