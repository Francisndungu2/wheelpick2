package com.demotxt.wheelpick2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;


public class DashboardActivity extends AppCompatActivity {

    Button btn_signout;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btn_signout = findViewById(R.id.signoutBtn);
        mAuth = FirebaseAuth.getInstance();

        btn_signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                startActivity(new Intent(DashboardActivity.this, MainActivity.class));
            }
        });


    }
}