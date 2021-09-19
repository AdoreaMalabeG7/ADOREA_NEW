package com.example.helping_hands;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.R;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    Button rgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        rgs=findViewById(R.id.rg);
        rgs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tskend = new Intent(MainActivity2.this, com.example.firstproject.hospitals.class);
                startActivity(tskend);
            }
        });
    }
}