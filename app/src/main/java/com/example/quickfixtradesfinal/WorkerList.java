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

public class WorkerList extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference workerDbRef;
    MyAdapter myAdapter;
    ArrayList<Worker> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_list);

        recyclerView = findViewById(R.id.userList);
        workerDbRef = FirebaseDatabase.getInstance().getReference("Workers");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        myAdapter = new MyAdapter(this, list);
        recyclerView.setAdapter(myAdapter);

        EditText searchWorker = findViewById(R.id.searchWorker);
        searchWorker.addTextChangedListener(new TextWatcher() {
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





        workerDbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){

                    Worker worker = dataSnapshot.getValue(Worker.class);
                    list.add(worker);
                }

                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
        private void filter(String text) {
            ArrayList <Worker> filteredList = new ArrayList<>();

            for (Worker trade: list) {
                if (trade.getSkill().toLowerCase().contains(text.toLowerCase())){
                    filteredList.add(trade);

                }
            }
            myAdapter.searchWorker(filteredList);


    }

}