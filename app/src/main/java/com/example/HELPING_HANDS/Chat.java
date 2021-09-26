package com.example.HELPING_HANDS;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Chat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Button button = (Button) findViewById(R.id.conf);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openCertificate();
            }
        });
    }

    public void openCertificate(){
        Intent intent = new Intent(this, Certificate.class);
        startActivity(intent);
    }
}