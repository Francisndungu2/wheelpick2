package com.demotxt.myapp.myapplication.activities;

import android.content.Intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.demotxt.myapp.myapplication.R;



public class form extends AppCompatActivity {
    private Button next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        next = (Button)findViewById(R.id.open);
        next.setOnClickListener(new View.OnClickListener() {


            @Override

            public void onClick(View v) {


                Intent intent = new Intent(form.this, about.class);
                startActivity(intent);

            }

        });
    }
};

