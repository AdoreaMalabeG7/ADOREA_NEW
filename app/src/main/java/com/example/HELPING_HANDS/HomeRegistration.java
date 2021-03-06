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

public class HomeRegistration extends AppCompatActivity {
    EditText place, address,type, phone, mCount, fCount;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_registration);

        place=(EditText)findViewById(R.id.add_place);
        address=(EditText)findViewById(R.id.add_address);
        phone=(EditText)findViewById(R.id.add_phone);
        mCount=(EditText)findViewById(R.id.add_mCount);
        fCount=(EditText)findViewById(R.id.add_fCount);
        type=(EditText) findViewById(R.id.add_type);

        submit = (Button) findViewById(R.id.add_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processinsert();
            }
        });


    }

    private void processinsert() {
        Map<String,Object> map = new HashMap<>();
        map.put("place",place.getText().toString());
        map.put("address",address.getText().toString());
        map.put("phone",phone.getText().toString());
        map.put("type",type .getText().toString());
        map.put("mCount",mCount.getText().toString());
        map.put("fCount",fCount.getText().toString());
        FirebaseDatabase.getInstance().getReference().child("care_home").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        place.setText("");
                        address.setText("");
                        phone.setText("");
                        mCount.setText("");
                        fCount.setText("");
                        type.setText("");
                        Toast.makeText(getApplicationContext(), "Inserted Successfully",Toast.LENGTH_LONG).show();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull  Exception e) {
                        Toast.makeText(getApplicationContext(), "Could Not Insert Data",Toast.LENGTH_LONG).show();

                    }
                });
    }
}