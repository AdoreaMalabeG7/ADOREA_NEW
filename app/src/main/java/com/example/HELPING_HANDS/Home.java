package com.example.HELPING_HANDS;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Home extends AppCompatActivity {
    Button btn1, btn2;
    ImageButton btnImg1, btnImg2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnImg1 = (ImageButton) findViewById(R.id.imageButton6);
        btnImg2 = (ImageButton) findViewById(R.id.imageButton7);

        btn1 = (Button) findViewById(R.id.button12);
        btn2 = (Button) findViewById(R.id.button13);

        btnImg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openUsers();
            }
        });

        btnImg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openChat();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openUsers();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openChat();
            }
        });
    }

    public void openUsers(){
        Intent intent = new Intent(this, MyAdapter.class);
        startActivity(intent);
    }

    public void openChat(){
        Intent intent = new Intent(this, Chat.class);
        startActivity(intent);
    }
}