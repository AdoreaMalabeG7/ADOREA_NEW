package com.example.HELPING_HANDS;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class UsersList extends AppCompatActivity {
    TextView no;
    RecyclerView recyclerView;
    DatabaseReference db;
    MyAdapter myAdapter;
    ArrayList<User> list;
   /* Button button1;
    ImageButton button2;
    ImageButton button3;*/

    public UsersList(View v){
        no = v.findViewById(R.id.textView15);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);

        /*button1 = (Button) findViewById(R.id.button8);
        button2 = (ImageButton) findViewById(R.id.imageButton2);
        button3 = (ImageButton) findViewById(R.id.floatingActionButton);*/

        recyclerView = findViewById(R.id.ulist);
        db = FirebaseDatabase.getInstance().getReference("UserDtl");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        myAdapter = new MyAdapter(this,list);
        recyclerView.setAdapter(myAdapter);

        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    User user = dataSnapshot.getValue(User.class);
                    list.add(user);
                }
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

       /* button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openPreview();
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openPreview();
            }
        });

        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openSignUp();
            }
        });*/
    }


    public void openPreview(){
        Intent intent = new Intent(this, Preview.class);
        startActivity(intent);
    }

    public void openSignUp(){
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }
}