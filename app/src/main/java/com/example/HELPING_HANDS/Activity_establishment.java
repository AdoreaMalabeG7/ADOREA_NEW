package com.example.HELPING_HANDS;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_establishment extends AppCompatActivity {
    private Button button10;
    private Button button11;
    private Button button12;
    private Button button14;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_establishment);

        button10 = (Button) findViewById(R.id.button10);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegistration();
            }
        });

        button11 = (Button) findViewById(R.id.button11);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDhanares();
            }
        });
        button12 = (Button) findViewById(R.id.button12);
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegistered();
            }
        });
        button14 = (Button) findViewById(R.id.button14);
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDhana();
            }
        });
    }


    public void openRegistration(){
        Intent intent = new Intent(this, HomeRegistration.class);
        startActivity(intent);
    }

    public void openDhanares(){
        Intent intent1 = new Intent(this, mealType.class);
        startActivity(intent1);
    }

    public void openRegistered(){
        Intent intent2 = new Intent(this, registeredHomes.class);
        startActivity(intent2);
    }

    public void  openDhana(){
        Intent intent3 = new Intent(this, Dhana.class);
        startActivity(intent3);
    }
}