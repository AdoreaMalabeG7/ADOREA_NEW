package com.example.HELPING_HANDS;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
    private Button signup;
    private Button login;
    private EditText Eemail, Epwd;
    private String femail, fpassword;
    private FirebaseAuth mAuth;
    private final String TAG = "Login";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);
        Eemail = findViewById(R.id.email);
        Epwd = findViewById(R.id.pwd);
        signup = findViewById(R.id.button3);
        login = findViewById(R.id.button2);

        mAuth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String email = Eemail.getText().toString();
                String password = Epwd.getText().toString();
                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter email and password", Toast.LENGTH_LONG).show();
                    return;
                }
                mAuth.signInWithEmailAndPassword(femail,fpassword)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "signInWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Toast.makeText(Login.this, "Login successfull", Toast.LENGTH_LONG).show();
                                    updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "signInWithEmail:failure", task.getException());
                                    Toast.makeText(Login.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openSignUp();
            }
        });

        /*login.setOnClickListener(view -> {
                loginUser();
        });
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                loginUser();
            }
        });*/
    }

    public void onStart(){
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            updateUI(currentUser);
        }
    }

    public void updateUI(FirebaseUser currentUser){
        Intent intent = new Intent(this, Preview.class);
        startActivity(intent);
        intent.putExtra("email", currentUser.getEmail());
    }

    public void openSignUp()
    {
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }

    /*public void openHome(){
        Intent intent = new Intent(this, Home.class);
    }*/

    public void Preview(){
        Intent intent = new Intent(this, Preview.class);
        startActivity(intent);
    }
}
    /*private Boolean validateUserName(){
        String val = uname.getText().toString();

        if(val.isEmpty()){
            uname.setError("Field cannot be empty");
            return false;
        }
        else{
            uname.setError(null);
            return false;
        }
    }
    private Boolean validatePassword(){
        String val = uname.getText().toString();

        if(val.isEmpty()){
            uname.setError("Field cannot be empty");
            return false;
        }
        else{
            uname.setError(null);
            return false;
        }
    }

    private void loginUser(){
        String email = Eemail.getText().toString().trim();
        String pwd = Epwd.getText().toString().trim();

        if(email.isEmpty()){
            Eemail.setError("Field cannot be empty");
            Eemail.requestFocus();
            return;
        }
        if(pwd.isEmpty()){
            Epwd.setError("Field cannot be empty");
            Epwd.requestFocus();
            return;
        }
        auth.signInWithEmailAndPassword(email,pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    login.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View v){
                            Toast.makeText(Login.this, "Login successfull", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(Login.this, Preview.class);
                            //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            //startActivity(new Intent(Login.this, Preview.class));
                        }
                    });

                } else {
                    Toast.makeText(Login.this, "Login Error" + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }*/


    /*private void isUser(){
        String EnterUname = uname.getText().toString();
        String EnterPwd = pwd.getText().toString();

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("UserDtl");

        Query checkUser = ref.orderByChild("uname").equalTo(EnterUname);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){

                    uname.setError(null);
                    //uname.setErrorEnabled(false);

                    String pwdDb = snapshot.child(EnterUname).child("pwd").getValue(String.class);
                    if(pwdDb.equals(EnterPwd)){
                        String nameDb = snapshot.child(EnterUname).child("name").getValue(String.class);
                        String emailDb = snapshot.child(EnterUname).child("email").getValue(String.class);
                        String pnumDb = snapshot.child(EnterUname).child("pnumm").getValue(String.class);
                        String unameDb = snapshot.child(EnterUname).child("uname").getValue(String.class);

                        Intent intent = new Intent( (),Home.class);

                        intent.putExtra("name", nameDb);
                        intent.putExtra("email", emailDb);
                        intent.putExtra("pnum", pnumDb);
                        intent.putExtra("uname", unameDb);
                        intent.putExtra("pwd", pwdDb);

                        startActivity(intent);
                    }
                    else{
                        pwd.setError("Incorrect Password");
                        pwd.requestFocus();
                    }
                }
                else{
                    uname.setError("No such User");
                    uname.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }*/

