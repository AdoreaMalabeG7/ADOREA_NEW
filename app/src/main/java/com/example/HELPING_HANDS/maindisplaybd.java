package com.example.HELPING_HANDS;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class maindisplaybd extends AppCompatActivity {

Button bld,lnh,rqs,blb;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maindisplaybd);

        bld=findViewById(R.id.BD);

        bld.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent tsk = new Intent(maindisplaybd.this, profilebd.class);
                startActivity(tsk);
            }
        });

        lnh=findViewById(R.id.LH);
        lnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tsk2 = new Intent(maindisplaybd.this, hospitalsbd.class);
                startActivity(tsk2);
            }
        });

        rqs=findViewById(R.id.RQ);
        rqs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tsk3 = new Intent(maindisplaybd.this, requestsbd.class);
                startActivity(tsk3);
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
    }
}