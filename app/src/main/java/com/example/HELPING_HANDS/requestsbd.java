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

public class requestsbd extends AppCompatActivity {
    EditText nme,nd,nm;
    Button con;
    DatabaseReference refff;
    long  idr=0;
    memberReq mem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requestsbd);

        nme = (EditText)findViewById(R.id.namerq);
        nd = (EditText)findViewById(R.id.nd);
        nm =(EditText)findViewById(R.id.cnum);
        con=(Button)findViewById(R.id.conf) ;


        mem= new memberReq();

            refff = FirebaseDatabase.getInstance().getReference().child("Requests");

            refff.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot DataSnapshot) {
                    idr=( DataSnapshot.getChildrenCount());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });


            con.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    //String name = nme.getText().toString().trim();
                    String need =  nd.getText().toString().trim();
                    String num = nm.getText().toString().trim();

                    mem.setName(nme.getText().toString().trim());
                    mem.setNeed(need);
                    mem.setContactNumber(num);


                    refff.push().setValue(mem);

                    refff.child(String.valueOf(idr+1)).setValue(mem);

                    Toast.makeText(requestsbd.this,"data inserted",Toast.LENGTH_LONG).show();


                }
            });




    }
}