package com.example.periodical_one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    TextView t1;
    RadioGroup rg1,rg2,rg3;
    RadioButton rb1,rb2,rb3,rb4,rb5,rb6;
    int count=0;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle b=getIntent().getExtras();
        String name=b.getString("name");
        String num=b.getString("num");
        t1=(TextView)findViewById(R.id.msg);
        String test = "\nWelcome :  "+ name +
                " \n\nContact:  "+ num;
        t1.setText(test);
        rg1=findViewById(R.id.RadioGroup1);
        rg2=findViewById(R.id.RadioGroup2);
        rg3=findViewById(R.id.RadioGroup3);
        rb1=findViewById(R.id.radioButton1);
        rb2=findViewById(R.id.radioButton2);
        rb3=findViewById(R.id.radioButton3);
        rb4=findViewById(R.id.radioButton4);
        rb5=findViewById(R.id.radioButton5);
        rb6=findViewById(R.id.radioButton6);
        rg1.setOnCheckedChangeListener(this);
        rg2.setOnCheckedChangeListener(this);
        rg3.setOnCheckedChangeListener(this);
        b1 = findViewById(R.id.button2);
        b1.setOnClickListener(this);





    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.button2) {
            String count1=String.valueOf(count);
            Toast.makeText(this, "Quized!", Toast.LENGTH_LONG).show();
            Intent i = new Intent(this, Main3Activity.class);
            Bundle b = getIntent().getExtras();
            String num = b.getString("num");
            i.putExtra("num", num);
            i.putExtra("Score",count1);
            startActivity(i);
        }

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        RadioButton rb = (RadioButton) findViewById(i);
        //Toast.makeText(getApplicationContext(),rb.getText(),Toast.LENGTH_SHORT).show();
        if(i == R.id.radioButton1|| i == R.id.radioButton3|| i == R.id.radioButton5)
        {
            count++;
            //t1.setText(String.valueOf(count));
            //Toast.makeText(getApplicationContext(),rb.getText(),Toast.LENGTH_SHORT).show();
        }
        else
        {
            //Toast.makeText(getApplicationContext(),rb.getText(),Toast.LENGTH_SHORT).show();
        }

    }
}