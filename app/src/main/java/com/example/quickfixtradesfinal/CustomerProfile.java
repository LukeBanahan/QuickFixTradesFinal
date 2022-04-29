package com.example.quickfixtradesfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CustomerProfile extends AppCompatActivity {
    private EditText fullNameTxt, phoneNumberTxt, locationTxt, tradeTxt;
    private Button submitBtn, listWorkerBtn;

    DatabaseReference customerDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_profile);


        fullNameTxt = findViewById(R.id.tvFullName);
        phoneNumberTxt = findViewById(R.id.phoneNumber);
        locationTxt = findViewById(R.id.location);
        tradeTxt = findViewById(R.id.trade);

        submitBtn = findViewById(R.id.submitWorker);
        listWorkerBtn = findViewById(R.id.listWorkerBtn);

        customerDbRef = FirebaseDatabase.getInstance().getReference().child("Customers");

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertCustomerData();
            }
        });
        listWorkerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listWorkers();
            }

        });
    }

    private void insertCustomerData() {

        String fullName = fullNameTxt.getText().toString().trim();
        String phoneNumber = phoneNumberTxt.getText().toString().trim();
        String location = locationTxt.getText().toString().trim();
        String need = tradeTxt.getText().toString().trim();

        if (fullName.isEmpty()) {
            fullNameTxt.setError("Please enter your name.");
            fullNameTxt.requestFocus();
            return;
        }

        if (phoneNumber.isEmpty()) {
            phoneNumberTxt.setError("Please enter a phone number.");
            phoneNumberTxt.requestFocus();
            return;
        }

        if (location.isEmpty()) {
            locationTxt.setError("Please enter a location.");
            locationTxt.requestFocus();
            return;
        }

        if (need.isEmpty()) {
            tradeTxt.setError("Please enter the trade worker you need.");
            tradeTxt.requestFocus();
            return;

        } else {

            Customer customer = new Customer(fullName, phoneNumber, location, need);

            customerDbRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                    .setValue(customer);
            Toast.makeText(CustomerProfile.this, "Profile Created", Toast.LENGTH_LONG).show();

        }

        }
        private void listWorkers () {
            startActivity(new Intent(this, WorkerList.class));
    }
}