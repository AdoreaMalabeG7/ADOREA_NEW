package com.example.HELPING_HANDS;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class bloodbank extends AppCompatActivity {
    int sum=0;
    TextView tot;
private DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bloodbank);
//
//        tot = (TextView)findViewById(R.id.tot);
//        ref=FirebaseDatabase.getInstance().getReference().child("BloodDonation");
//
//        ref.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//                for (DataSnapshot ds : dataSnapshot.getChildren()){
//                    Map<String,Object> map=(Map<String,Object>) ds.getValue();
//                    Object number =map.get("number");
//                    int nValue = Integer.parseInt(String.valueOf(number));
//                    sum+=nValue;
//
//                    tot.setText(String.valueOf(sum));
//
//
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        })





    }
}