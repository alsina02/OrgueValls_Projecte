package com.example.orguevalls_projecte;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class A31 extends AppCompatActivity {


    private Button imgButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a31);



        imgButton = (Button) findViewById(R.id.botoR3);
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(A31.this, "gj boy", Toast.LENGTH_LONG).show();
            }
        });

    }}