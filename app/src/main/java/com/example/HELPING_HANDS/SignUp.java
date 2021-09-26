package com.example.HELPING_HANDS;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignUp extends AppCompatActivity {
    EditText tname, temail, tpnum, tuname, tpwd;
    DatabaseReference ref;
    SignUpdb user;
    long maxid = 0;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();

        tname = (EditText) findViewById(R.id.name);
        temail = (EditText) findViewById(R.id.email);
        tpnum = (EditText) findViewById(R.id.pnum);
        tuname = (EditText) findViewById(R.id.uname);
        tpwd = (EditText) findViewById(R.id.pwd);
        user = new SignUpdb();

        ref=FirebaseDatabase.getInstance().getReference().child("UserDtl");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                    maxid=(dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        Button button = (Button) findViewById(R.id.button4);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //insertsignup();
                user.setName(tname.getText().toString().trim());
                user.setEmail(temail.getText().toString().trim());
                user.setPnum(tpnum.getText().toString().trim());
                user.setUname(tuname.getText().toString().trim());
                user.setPwd(tpwd.getText().toString().trim());

                ref.child(String.valueOf("U"+(maxid+1))).setValue(user);
                Toast.makeText(SignUp.this, "Data inserted successfully", Toast.LENGTH_LONG).show();
                openPreview();
            }
        });
    }

    /*public void insertsignup(){
        user.setName(tname.getText().toString().trim());
        user.setEmail(temail.getText().toString().trim());
        user.setPnum(tpnum.getText().toString().trim());
        user.setUname(tuname.getText().toString().trim());
        user.setPwd(tpwd.getText().toString().trim());

        ref.child(String.valueOf("U"+maxid+1)).setValue("user");
        Toast.makeText(SignUp.this, "Data inserted successfully", Toast.LENGTH_LONG).show();
    }*/

    public void openPreview(){
        Intent intent = new Intent(this, Preview.class);
        startActivity(intent);
    }

    public void openLogin(){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}