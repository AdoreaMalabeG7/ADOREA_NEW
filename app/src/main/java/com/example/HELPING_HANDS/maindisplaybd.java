package com.example.HELPING_HANDS;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//import android.widget.CheckBox;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class maindisplaybd extends AppCompatActivity {

    Button bld,lnh,rqs,blb,pfl;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maindisplaybd);

        bld=findViewById(R.id.BD);
        bld.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent tsk = new Intent(maindisplaybd.this, Registerbd.class);
                startActivity(tsk);
            }
        });

        lnh=findViewById(R.id.LH);
        lnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tsk1 = new Intent(maindisplaybd.this, hospitalsbd.class);
                startActivity(tsk1);
            }
        });

        rqs=findViewById(R.id.RQ);
        rqs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tsk2 = new Intent(maindisplaybd.this, requestsbd.class);
                startActivity(tsk2);
            }
        });

        blb=findViewById(R.id.BB);
        blb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tsk3 = new Intent(maindisplaybd.this,bloodbank.class);
                startActivity(tsk3);
            }
        });
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////Display Details///////////////////////////////////////////////////////////////////////




        pfl=(Button)findViewById(R.id.bdprof);
        pfl.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent tsk4 = new Intent(maindisplaybd.this,profilebd.class);
                startActivity(tsk4);






            }


      });


    }
}