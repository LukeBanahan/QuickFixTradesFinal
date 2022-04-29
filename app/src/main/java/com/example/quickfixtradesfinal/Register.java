package com.example.quickfixtradesfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity implements View.OnClickListener {
    private Button registerCustomer, toCustomerLogin;
    private FirebaseAuth mAuth;
    private EditText cEmail, cPassword, cPasswordConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        registerCustomer = (Button) findViewById(R.id.registerCustomer);
        registerCustomer.setOnClickListener(this);

        toCustomerLogin = (Button) findViewById(R.id.toCustomerLogin);
        toCustomerLogin.setOnClickListener(this);

        cEmail = (EditText) findViewById(R.id.cEmail);
        cPassword = (EditText) findViewById(R.id.cPassword);
        cPasswordConfirm= (EditText) findViewById(R.id.phoneNumber);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.registerCustomer:
                String email = cEmail.getText().toString().trim();
                String password = cPassword.getText().toString().trim();
                String passwordConfirm = cPasswordConfirm.getText().toString().trim();
                registerCUser(email, password, passwordConfirm);
                break;
            case R.id.toCustomerLogin:
                startActivity(new Intent(this, MainActivity.class));
        }

    }

    public void registerCUser(String email,String password,String passwordConfirm) {




        if (email.isEmpty()) {
            cEmail.setError("Email Address is required.");
            cEmail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            cPassword.setError("Password is required!");
            cPassword.requestFocus();
            return;
        }
        if (password.length() < 6) {
            cPassword.setError("Password must be at least 6 characters long.");
            cPassword.requestFocus();
            return;
        }

        if (passwordConfirm.equals(password)) {
            mAuth.createUserWithEmailAndPassword(email, password);
            Toast.makeText(Register.this, "Account Registered Successfully", Toast.LENGTH_LONG).show();

        }else{
            cPasswordConfirm.setError("The passwords entered do not match");
            cPasswordConfirm.requestFocus();
            return;
        }


    }

    public boolean CheckSignIn(String email, String password) {
        boolean checkEmail = mAuth.signInWithEmailAndPassword(email, password).isSuccessful();
        return checkEmail;
    }
}
/* //CodeWithMazn
 *7/06/2020
 * #1 Login and Registration Android App Tutorial Using Firebase Authentication - Create User
 * | | Android Studio [video].
 * https://www.youtube.com/watch?v=Z-RE1QuUWPg */