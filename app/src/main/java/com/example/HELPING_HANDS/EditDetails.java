package com.example.HELPING_HANDS;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


public class EditDetails extends AppCompatActivity {
TextView n,e,p,un,pw;
Button upd;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        n=(TextView)findViewById(R.id.ename);
        e=(TextView)findViewById(R.id.em);
        p=(TextView)findViewById(R.id.ph);
        un=(TextView)findViewById(R.id.unm);
        pw=(TextView)findViewById(R.id.pwd);

        upd = findViewById(R.id.upd);
        reff = FirebaseDatabase.getInstance().getReference().child("UserDtl");

        upd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = n.getText().toString().trim();
                String email = e.getText().toString().trim();
                String phone = p.getText().toString().trim();
                String username = un.getText().toString().trim();
                String password = pw.getText().toString().trim();

                HashMap hashMap =new HashMap();
                hashMap.put("name",name);
                hashMap.put("email",email);
                hashMap.put("pnum",phone);
                hashMap.put("pwd",username);
                hashMap.put("uwd",password);


                reff.child("2").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(EditDetails.this,"updated",Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

    }
}