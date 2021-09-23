package com.example.HELPING_HANDS;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Registerbd extends AppCompatActivity {
    EditText bdFullname,bdBirth,bdWigth,bdAdrs,bdLdd,bdPhn;
    CheckBox bdG1,bdG2;
    Button rgs;

    FirebaseDatabase rootnode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerbd);

        bdFullname = findViewById(R.id.nameT);
        bdBirth = findViewById(R.id.WigtT);
        bdG1 = findViewById(R.id.GndM);
        bdG2 = findViewById(R.id.GndF);
        bdWigth = findViewById(R.id.WigtT);
        bdAdrs = findViewById(R.id.addrsT);
        bdLdd = findViewById(R.id.LddT);
        bdPhn = findViewById(R.id.PhnT);
        rgs=findViewById(R.id.rg);




        rgs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String name = bdFullname.getText().toString().trim();
                    String Bday = bdBirth.getText().toString().trim();
                    String weight = bdWigth.getText().toString().trim();
                    String adress = bdAdrs.getText().toString().trim();
                    String ldd = bdLdd.getText().toString().trim();
                    String phone = bdPhn.getText().toString().trim();

                rootnode=FirebaseDatabase.getInstance();
            reference=rootnode.getReference("Register");

//                bdHelperDB helperClass=new bdHelperDB(name,Bday,weight,adress,ldd,phone);
//            reference.child(phone).setValue(bdHelperDB);
//
            }
        });



            rgs=findViewById(R.id.rg);
        rgs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tskend = new Intent(Registerbd.this, hospitalsbd.class);
                startActivity(tskend);
            }
        });
    }
}