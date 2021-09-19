package com.example.HELPING_HANDS;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.R;

import androidx.appcompat.app.AppCompatActivity;

public class Registerbd extends AppCompatActivity {

    Button rgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.Registerbd);

        rgs=findViewById(R.id.rg);
        rgs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tskend = new Intent(Registerbd.this, com.example.HELPING_HANDS.hospitals.class);
                startActivity(tskend);
            }
        });
    }
}