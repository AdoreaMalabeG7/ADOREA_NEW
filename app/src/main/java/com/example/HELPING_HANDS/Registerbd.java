package com.example.HELPING_HANDS;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Registerbd extends AppCompatActivity {

    Button rgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerbd);

        rgs=findViewById(R.id.rg);
        rgs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tskend = new Intent(Registerbd.this, hospitalsbd.class);
                startActivity(tskend);
            }
        });
    }
}