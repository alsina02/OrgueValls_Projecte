package com.example.orguevalls_projecte;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class A12 extends AppCompatActivity {

    private ImageButton imgButton;
    private Button ba13;
    public DBHandler dbh = new DBHandler(this);
    @SuppressLint("MissingInflatedId")
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a12);
        setTitle(R.string.bQA);

        imgButton = (ImageButton) findViewById(R.id.imageButton2);
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(A12.this, "gj boy", Toast.LENGTH_LONG).show();
            }
        });

        ba13 = findViewById(R.id.botoA13);
        ba13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(A12.this, A13.class);
                A12.this.startActivity(myIntent);
    }
        });


    }
}