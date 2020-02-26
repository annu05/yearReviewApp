package com.example.yearreview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.BreakIterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button addbutton;
    MyDBHandler db;

    EditText txtname,txtimage,txtrating,txtstartdate,txtstartmonth,txtstartyear,txtenddate,txtendmonth,txtendyear,txtepisode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addbutton = (Button)findViewById(R.id.button1);
        txtname = (EditText)findViewById(R.id.name);
        txtimage = (EditText)findViewById(R.id.image);
        txtrating = (EditText)findViewById(R.id.rating);
        txtstartdate = (EditText)findViewById(R.id.startdate);
        txtstartmonth = (EditText)findViewById(R.id.startmonth);
        txtstartyear = (EditText)findViewById(R.id.startyear);
        txtenddate =(EditText)findViewById(R.id.enddate);
        txtendmonth =(EditText)findViewById(R.id.endmonth);
        txtendyear = (EditText)findViewById(R.id.endyear);
        txtepisode = (EditText)findViewById(R.id.episode);
        db = new MyDBHandler(this,null,null,1);


        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                       ClickMe();
            }
        });



    }
    private void ClickMe(){
        String name = txtname.getText().toString();
        String image = txtimage.getText().toString();
        String rating = txtrating.getText().toString();
        String startdate = txtstartdate.getText().toString();
        String startmonth = txtstartmonth.getText().toString();
        String startyear = txtstartyear.getText().toString();
        String enddate = txtenddate.getText().toString();
        String endmonth = txtendmonth.getText().toString();
        String endyear = txtendyear.getText().toString();
        String episode = txtepisode.getText().toString();
        Boolean result = db.addHandler(name,image,rating,startdate,startmonth,startyear,enddate,endmonth,endyear,episode);
        if(result == true){
            Toast.makeText(this, "Data inserted Successfully", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Data insertion failed", Toast.LENGTH_SHORT).show();
        }

    }






}
