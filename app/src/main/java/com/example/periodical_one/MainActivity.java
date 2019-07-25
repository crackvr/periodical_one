package com.example.periodical_one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,View.OnClickListener {

    Button b1;
    EditText ed1,ed2;
    Spinner s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.button);
        b1.setOnClickListener(this);
        ed1 = (EditText) findViewById(R.id.editText);
        ed2 = (EditText) findViewById(R.id.editText2);
        String days[]={"Vij","Vizaj","Coimb","Hyd","ongole"};
        s=(Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adap2=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,days);
        s.setAdapter(adap2);
        s.setOnItemSelectedListener(this);

    }

    @Override
    public void onClick(View view) {
        String name=ed1.getText().toString().trim();
        String num=ed2.getText().toString().trim();
        if(name.equals("")||num.equals(""))
        {
            Toast.makeText(this,"Please Fill All The Fields!!!!!", Toast.LENGTH_LONG).show();

        }
        else{
            Intent i=new Intent(this,Main2Activity.class);
            i.putExtra("name",name);
            i.putExtra("num",num);
            Toast.makeText(this,"Going to start quiz!!!!!", Toast.LENGTH_LONG).show();
            startActivity(i);
        }

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(adapterView.getId()==R.id.spinner) {
            Log.d("MainActivity", "item selected");
            TextView txt = (TextView) view;
            //Checked Text view
            Log.d("spinner",txt.getText().toString());
            Toast.makeText(getApplicationContext(), "You have selected " + txt.getText(), Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Toast.makeText(getApplicationContext(), "No selection yet", Toast.LENGTH_SHORT).show();
    }
}