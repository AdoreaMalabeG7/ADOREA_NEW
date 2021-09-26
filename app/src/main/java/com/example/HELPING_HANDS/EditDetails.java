package com.example.HELPING_HANDS;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class EditDetails extends AppCompatActivity {
    EditText tname, temail, tpnum, tuname, tpwd;
    Button btnUpdate;
    DatabaseReference ref;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_details);

        btnUpdate = (Button) findViewById(R.id.button7);

        tname = (EditText) findViewById(R.id.ename);
        temail = (EditText) findViewById(R.id.editTextTextPersonName9);
        tpnum = (EditText) findViewById(R.id.editTextTextPersonName10);
        tuname = (EditText) findViewById(R.id.editTextTextPersonName11);
        tpwd = (EditText) findViewById(R.id.editTextTextPersonName12);

        ref = FirebaseDatabase.getInstance().getReference().child("UserDtl").child("U5");

        ref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot DataSnapshot) {
                String name = DataSnapshot.child("name").getValue().toString();
                String email = DataSnapshot.child("email").getValue().toString();
                String pnumber = DataSnapshot.child("pnum").getValue().toString();
                String username = DataSnapshot.child("uname").getValue().toString();
                String password = DataSnapshot.child("pwd").getValue().toString();

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

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = tname.getText().toString().trim();
                String email = tname.getText().toString().trim();
                String pnumber = tname.getText().toString().trim();
                String username = tname.getText().toString().trim();
                String password = tname.getText().toString().trim();

                HashMap hashMap = new HashMap();
                hashMap.put("name", name);
                hashMap.put("email", email);
                hashMap.put("pnum", pnumber);
                hashMap.put("uname", username);
                hashMap.put("pwd", password);

                ref.child("U6").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o ) {
                        Toast.makeText(EditDetails.this, "Details Updated", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }
}

 /*       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnUpdate = (Button) findViewById(R.id.upd);
        ref = FirebaseDatabase.getInstance().getReference().child("UserDtl");

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = fn.getText().toString().trim();
                String email = fn.getText().toString().trim();
                String pnumber = fn.getText().toString().trim();
                String username = fn.getText().toString().trim();
                String password = fn.getText().toString().trim();

                HashMap hashMap =new HashMap();
                hashMap.put("name",name);
                hashMap.put("email",email);
                hashMap.put("pnum",pnumber);
                hashMap.put("uname",username);
                hashMap.put("pwd",password);

                ref.child("5").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(EditDetails.this,"updated",Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

    }
}*/