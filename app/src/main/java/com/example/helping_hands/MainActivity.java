package com.example.helping_hands;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.R;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

Button bld,lnh,rqs,blb;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bld=findViewById(R.id.BD);

        bld.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent tsk = new Intent(MainActivity.this,profile.class);
                startActivity(tsk);
            }
        });

        lnh=findViewById(R.id.LH);
        lnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tsk2 = new Intent(MainActivity.this,hospitals.class);
                startActivity(tsk2);
            }
        });

        rqs=findViewById(R.id.RQ);
        rqs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tsk3 = new Intent(MainActivity.this,requests.class);
                startActivity(tsk3);
            }
        });

        blb=findViewById(R.id.BB);
        blb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tsk3 = new Intent(MainActivity.this,bloodbank.class);
                startActivity(tsk3);
            }
        });
    }
}