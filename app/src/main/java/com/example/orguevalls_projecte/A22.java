package com.example.orguevalls_projecte;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class A22 extends AppCompatActivity {

    private Button ba31;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a22);


        ba31 = findViewById(R.id.botoA31);
        ba31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(A22.this, A31.class);
                A22.this.startActivity(myIntent);
            }
        });


    }
}