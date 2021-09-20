package com.example.HELPING_HANDS;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Preview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        Button button1 = (Button) findViewById(R.id.button5);

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openEditDetails();
            }
        });
    }

    public void openEditDetails(){
        Intent intent = new Intent(this, EditDetails.class);
        startActivity(intent);
    }
}