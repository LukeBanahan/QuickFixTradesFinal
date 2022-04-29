package com.example.quickfixtradesfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Choice extends AppCompatActivity implements View.OnClickListener {
    private Button cProfile, wProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        cProfile = (Button) findViewById(R.id.cProfile);
        cProfile.setOnClickListener(this);

        wProfile = (Button) findViewById(R.id.wProfile);
        wProfile.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cProfile:
                startActivity(new Intent(this, CustomerProfile.class));
                break;
            case R.id.wProfile:
                startActivity(new Intent(this, WorkerProfile.class));
        }
    }
}
