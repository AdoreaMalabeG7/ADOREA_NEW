package com.example.HELPING_HANDS;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Users extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        Button button1 = (Button) findViewById(R.id.button8);
        ImageButton button2 = (ImageButton) findViewById(R.id.imageButton2);
        ImageButton button3 = (ImageButton) findViewById(R.id.floatingActionButton);

        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openPreview();
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openPreview();
            }
        });

        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openSignUp();
            }
        });
    }

    public void openPreview(){
        Intent intent = new Intent(this, Preview.class);
        startActivity(intent);
    }

    public void openSignUp(){
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }
}