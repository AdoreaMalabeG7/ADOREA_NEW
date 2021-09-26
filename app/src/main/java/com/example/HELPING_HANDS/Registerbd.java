package com.example.HELPING_HANDS;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Registerbd extends AppCompatActivity {
    EditText bdFullname,bdBirth,bdWigth,bdGrp,bdAdrs,bdLdd,bdPhn;
    CheckBox bdGm;
    Button rgs;
    long  id=0;

    DatabaseReference reff;
    MemberbdReg member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerbd);

        bdFullname = (EditText)findViewById(R.id.nameT);
        bdBirth = (EditText)findViewById(R.id.BdayTt);
        bdGm =(CheckBox)findViewById(R.id.Gnd);
//        bdGf =(CheckBox)findViewById(R.id.Gndf);
        bdWigth = (EditText)findViewById(R.id.weightTt);
        bdGrp = (EditText)findViewById(R.id.bgrTt);
        bdAdrs = (EditText)findViewById(R.id.ads);
        bdLdd = (EditText)findViewById(R.id.LddTt);
        bdPhn = (EditText)findViewById(R.id.PhnTt);
        rgs=(Button) findViewById(R.id.rg);

        member= new MemberbdReg();

        reff = FirebaseDatabase.getInstance().getReference().child("BloodDonation");

        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot DataSnapshot) {
                id=( DataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        rgs.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                   //String name = bdFullname.getText().toString().trim();
                    int Bday = Integer.parseInt (bdBirth.getText().toString().trim());
                    String gender =  bdGm.getText().toString().trim();
                    int weight = Integer.parseInt(bdWigth.getText().toString().trim());
                    String bloodgruop = bdGrp.getText().toString().trim();
                    String adress = bdAdrs.getText().toString().trim();
                    int ldd = Integer.parseInt(bdLdd.getText().toString().trim());
                    int phone = Integer.parseInt(bdPhn.getText().toString().trim());

                member.setName(bdFullname.getText().toString().trim());
                member.setBirthDay(Bday);
                member.setGender(gender);
                member.setWigth(weight);
                member.setBloodgruop(bloodgruop);
                member.setAdress(adress);
                member.setLadtDonatedate(ldd);
                member.setPhone(phone);

                reff.push().setValue(member);

                reff.child(String.valueOf(id+1)).setValue(member);

                Toast.makeText(Registerbd.this,"data inserted",Toast.LENGTH_LONG).show();


                Intent tskend = new Intent(Registerbd.this, hospitalsbd.class);
                startActivity(tskend);

            }
        });

    }
}