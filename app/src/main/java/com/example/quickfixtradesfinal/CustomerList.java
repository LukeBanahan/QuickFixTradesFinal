package com.example.quickfixtradesfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Locale;

public class CustomerList extends AppCompatActivity {

    RecyclerView cRecyclerView;
    DatabaseReference customerDbRef;
    MyCustomerAdapter myCustomerAdapter;
    ArrayList <Customer> cList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);

        cRecyclerView = findViewById(R.id.userList);
        customerDbRef = FirebaseDatabase.getInstance().getReference("Customers");
        cRecyclerView.setHasFixedSize(true);
        cRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        cList = new ArrayList<>();

        myCustomerAdapter = new MyCustomerAdapter(this,cList);
        cRecyclerView.setAdapter(myCustomerAdapter);

        EditText search = findViewById(R.id.searchCustomer);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());

            }
        });



                customerDbRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                            Customer customer = dataSnapshot.getValue(Customer.class);
                            cList.add(customer);
                        }
                        myCustomerAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {


                    }
                });

                }
                private void filter(String text) {
                    ArrayList<Customer> filteredList = new ArrayList<>();
                    for(Customer location :cList) {
                        if(location.getLocation().toLowerCase().contains(text.toLowerCase())) {
                            filteredList.add(location);
            }

        }
          myCustomerAdapter.filterList(filteredList);

    }
}
/* //Coding In Flow
 *16/11/2017
 * #Search Functionality for RecyclerView - Android Studio Tutorial
 * | | Android Studio [video].
 * https://www.youtube.com/watch?v=OWwOSLfWboY&t=271s */