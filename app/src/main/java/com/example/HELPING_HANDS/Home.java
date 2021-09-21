package com.example.HELPING_HANDS;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ImageButton btnImg1 = (ImageButton) findViewById(R.id.imageButton6);
        ImageButton btnImg2 = (ImageButton) findViewById(R.id.imageButton7);

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
    }

    public void openUsers(){
        Intent intent = new Intent(this, Users.class);
        startActivity(intent);
    }

    public void openChat(){
        Intent intent = new Intent(this, Chat.class);
        startActivity(intent);
    }
}