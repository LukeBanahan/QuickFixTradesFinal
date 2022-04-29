package com.example.quickfixtradesfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class WorkerProfile extends AppCompatActivity {
    private EditText fullNameTxt, phoneNumberTxt, locationTxt, skillTxt;
    private Spinner locationSpinner, skillSpinner;
    private Button submitBtn, showCustomerBtn;

    DatabaseReference workerDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_profile);


        fullNameTxt = findViewById(R.id.tvFullName);
        phoneNumberTxt = findViewById(R.id.phoneNumber);
        locationTxt = findViewById(R.id.wLocation);
        skillTxt = findViewById(R.id.skill);
        submitBtn = findViewById(R.id.submitWorker);
        showCustomerBtn = findViewById(R.id.showCustomersBtn);




        workerDbRef = FirebaseDatabase.getInstance().getReference().child("Workers");

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertWorkerData();
            }
        });

        showCustomerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomers();
            }
        });
    }

    private void showCustomers() {
        startActivity(new Intent(this, CustomerList.class));
    }



    private void insertWorkerData() {

        String fullName = fullNameTxt.getText().toString().trim();
        String phoneNumber = phoneNumberTxt.getText().toString().trim();
        String location = locationTxt.getText().toString().trim();
        String skill = skillTxt.getText().toString().trim();

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

        if (skill.isEmpty()) {
            skillTxt.setError("Please enter your trade.");
            skillTxt.requestFocus();
            return;
        } else {

            Worker worker = new Worker(fullName, phoneNumber, location, skill);

            workerDbRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                    .setValue(worker);
            Toast.makeText(WorkerProfile.this, "Profile Created", Toast.LENGTH_LONG).show();



            //* workerDbRef.push().setValue(worker);
            //*Toast.makeText(WorkerProfile.this, "Profile Created",Toast.LENGTH_LONG).show();;;
        }
    }
}

