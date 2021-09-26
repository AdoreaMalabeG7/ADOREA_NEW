package com.example.HELPING_HANDS;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class mealType extends AppCompatActivity {
    EditText name,date,home,meal;
    Button reserve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_type);
        name = (EditText) findViewById(R.id.add_name);
        date = (EditText) findViewById(R.id.add_date);
        home = (EditText) findViewById(R.id.add_home);
        meal = (EditText) findViewById(R.id.add_meal);

        reserve = (Button) findViewById(R.id.reserve);
        reserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proinsert();
            }
        });

    }

        private void proinsert(){
            Map<String,Object> map = new HashMap<>();
            map.put("name",name.getText().toString());
            map.put("date",date.getText().toString());
            map.put("home",home.getText().toString());
            map.put("meal",meal.getText().toString());
            FirebaseDatabase.getInstance().getReference().child("dhana").push()
                    .setValue(map)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            name.setText("");
                            date.setText("");
                            home.setText("");
                            meal.setText("");
                            Toast.makeText(getApplicationContext(), "Inserted Successfully",Toast.LENGTH_LONG).show();

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(), "Could Not Insert Data",Toast.LENGTH_LONG).show();

                        }
                    });



    }
}