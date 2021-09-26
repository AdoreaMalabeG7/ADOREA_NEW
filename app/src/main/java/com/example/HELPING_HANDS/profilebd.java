package com.example.HELPING_HANDS;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;


public class profilebd extends AppCompatActivity {


    TextView fn,bd,wigt,bg,ads,ld,ph,gnd;
    Button up,dlt;
    DatabaseReference reff;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilebd);

//retrieve

        fn=(TextView)findViewById(R.id.nameT);
        bd=(TextView)findViewById(R.id.BdayTt);
        wigt=(TextView)findViewById(R.id.weightTt);
        ads=(TextView)findViewById(R.id.ads);
        bg=(TextView)findViewById(R.id.bgrTt);
        ld=(TextView)findViewById(R.id.LddTt);
        ph=(TextView)findViewById(R.id.PhnTt);
        gnd=(TextView)findViewById(R.id.gndTt);


        reff = FirebaseDatabase.getInstance().getReference().child("BloodDonation").child("2");

        reff.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot DataSnapshot) {

                String name=DataSnapshot.child("name").getValue().toString();
                String bday=DataSnapshot.child("birthDay").getValue().toString();
                String gndr=DataSnapshot.child("gender").getValue().toString();
                String wgh=DataSnapshot.child("wigth").getValue().toString();
                String blgruop=DataSnapshot.child("bloodgruop").getValue().toString();
                String adrs=DataSnapshot.child("adress").getValue().toString();
                String laDondate=DataSnapshot.child("ladtDonatedate").getValue().toString();
                String phn=DataSnapshot.child("phone").getValue().toString();


                fn.setText(name);
                bd.setText(bday);
                wigt.setText(wgh);
                bg.setText(blgruop);
                ads.setText(adrs);
                ld.setText(laDondate);
                ph.setText(phn);
                gnd.setText(gndr);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

///update

        up = findViewById(R.id.upd);
        reff = FirebaseDatabase.getInstance().getReference().child("BloodDonation");

        up.setOnClickListener(new OnClickListener() {
           @Override
           public void onClick(View view) {

               String name = fn.getText().toString().trim();
               int Bday = Integer.parseInt (bd.getText().toString().trim());
               String gender =  gnd.getText().toString().trim();
               int weight = Integer.parseInt(wigt.getText().toString().trim());
               String bloodgruop = bg.getText().toString().trim();
               String adress = ads.getText().toString().trim();
               int ldd = Integer.parseInt(ld.getText().toString().trim());
               int phone = Integer.parseInt(ph.getText().toString().trim());


               HashMap hashMap =new HashMap();
               hashMap.put("name",name);
               hashMap.put("birthDay",Bday);
               hashMap.put("gender",gender);
               hashMap.put("wigth",weight);
               hashMap.put("bloodgruop",bloodgruop);
               hashMap.put("adress",adress);
               hashMap.put("ladtDonatedate",ldd);
               hashMap.put("phone",phone);

               reff.child("2").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                   @Override
                   public void onSuccess(Object o) {
                       Toast.makeText(profilebd.this,"updated",Toast.LENGTH_SHORT).show();
                   }
               });

           }
       });

//delete
        dlt =findViewById(R.id.del);
        dlt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                deleteUser();


            }
        });


    }
    public void deleteUser(){
        reff = FirebaseDatabase.getInstance().getReference("BloodDonation").child("2");
        reff.removeValue();
        Toast.makeText(this, "Details Deleted Successfully", Toast.LENGTH_LONG).show();
    }

}