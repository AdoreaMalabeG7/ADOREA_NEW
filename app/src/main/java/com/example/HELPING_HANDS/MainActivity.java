package com.example.HELPING_HANDS;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openUserList();
                //openLogin();
            }
        });
    }

    public void openUserList(){
        Intent intent = new Intent(this, UsersList.class);
        startActivity(intent);
    }

    public void openLogin(){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}