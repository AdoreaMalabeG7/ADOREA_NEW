package com.example.HELPING_HANDS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class registeredHomes extends AppCompatActivity {
    RecyclerView recyclerView;
    RegisterAdapter registerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered_homes);

        recyclerView = (RecyclerView)findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<RegisterModel> options =
                new FirebaseRecyclerOptions.Builder<RegisterModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("care_home"), RegisterModel.class)
                        .build();
        registerAdapter = new RegisterAdapter(options);
        recyclerView.setAdapter(registerAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        registerAdapter.stopListening();
    }
}