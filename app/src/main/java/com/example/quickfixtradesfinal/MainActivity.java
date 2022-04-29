package com.example.quickfixtradesfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button cSignIn, cRegister;
    private EditText cEmail, cPassword;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cSignIn = (Button) findViewById(R.id.cSignIn);
        cSignIn.setOnClickListener(this);

        cRegister = (Button) findViewById(R.id.cRegister);
        cRegister.setOnClickListener(this);

        cEmail = (EditText) findViewById(R.id.cEmail);
        cPassword = (EditText) findViewById(R.id.cPassword);

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cSignIn:
                String email = cEmail.getText().toString().trim();
                String password = cPassword.getText().toString().trim();
                userLogin(email, password);
                break;
            case R.id.cRegister:
                startActivity(new Intent(this, Register.class));
        }


    }
    private void userLogin(String email, String password) {


        if(email.isEmpty()){
            cEmail.setError("Please enter a valid email.");
            cEmail.requestFocus();
            return;
        }
        if(password.isEmpty()){
            cPassword.setError("Please enter a password.");
            cPassword.requestFocus();
            return;
        }
        if(password.length() <6 ){
            cPassword.setError("Password must be at least 6 characters long.");
            cPassword.requestFocus();
            return;
        }
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    startActivity(new Intent(MainActivity.this,Choice.class));

                }
                else{
                    Toast.makeText(MainActivity.this, "Log In Failed. Please Try again", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
/* //CodeWithMazn
 *7/06/2020
 * #1 Login and Registration Android App Tutorial Using Firebase Authentication - Create User
 * | | Android Studio [video].
 * https://www.youtube.com/watch?v=Z-RE1QuUWPg */