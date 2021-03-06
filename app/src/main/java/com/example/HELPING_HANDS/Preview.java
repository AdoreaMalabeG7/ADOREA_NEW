package com.example.HELPING_HANDS;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Preview extends AppCompatActivity {
    TextView tname, temail, tpnum, tuname, tpwd;
    Button btnEdit, btnDelete;
    DatabaseReference ref;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        btnEdit = (Button) findViewById(R.id.button5);
        btnDelete = (Button) findViewById(R.id.button6);

        tname = (TextView)findViewById(R.id.textView3);
        temail = (TextView)findViewById(R.id.textView4);
        tpnum = (TextView)findViewById(R.id.addrs);
        tuname = (TextView)findViewById(R.id.LDD);
        tpwd = (TextView)findViewById(R.id.textView34);

        ref = FirebaseDatabase.getInstance().getReference().child("UserDtl").child("U5");

        ref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot DataSnapshot) {
                String name=DataSnapshot.child("name").getValue().toString();
                String email=DataSnapshot.child("email").getValue().toString();
                String pnumber=DataSnapshot.child("pnum").getValue().toString();
                String username=DataSnapshot.child("uname").getValue().toString();
                String password=DataSnapshot.child("pwd").getValue().toString();

                tname.setText(name);
                temail.setText(email);
                tpnum.setText(pnumber);
                tuname.setText(username);
                tpwd.setText(password);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openEditDetails();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteUser();
            }
        });
    }

    public void openEditDetails(){
        Intent intent = new Intent(this, EditDetails.class);
        startActivity(intent);
    }

    public void deleteUser(){
        ref = FirebaseDatabase.getInstance().getReference("UserDtl").child("U5");
        ref.removeValue();
        Toast.makeText(this, "Details Deleted Successfully", Toast.LENGTH_LONG).show();
    }
}